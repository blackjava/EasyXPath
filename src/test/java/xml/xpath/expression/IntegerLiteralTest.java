package xml.xpath.expression;

import i18n.ErrorCode;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerLiteralTest {
    @Test
    public void empty_string_results_in_number_format_exception() {
        try {
            new IntegerLiteral("");
            fail("Creating an integer literal with an empty string should fail.");
        } catch (NumberFormatException nfe) {
            assertEquals(ErrorCode.COULD_NOT_PARSE_INTEGER, nfe.getErrorCode());
            
            String[] parameters = nfe.getParameters();
            assertEquals(1, parameters.length);
            assertEquals("", parameters[0]);
        }
    }
    
    @Test
    public void integer_is_properly_instantiated() {
        IntegerLiteral literal = new IntegerLiteral("123");
        assertEquals("123", literal.toString());
    }

    @Test
    public void fractal_results_in_number_format_exception() {
        try {
            new IntegerLiteral("123.4");
            fail("Creating an integer literal with fractions should fail.");
        } catch (NumberFormatException nfe) {
            assertEquals(ErrorCode.NUMBER_CONTAINS_INVALID_CHARACTER, nfe.getErrorCode());
            
            String[] parameters = nfe.getParameters();
            assertEquals(2, parameters.length);
            assertEquals("123.4", parameters[0]);
            assertEquals("3", parameters[1]);
        }
    }

    @Test
    public void string_results_in_number_format_exception() {
        try {
            new IntegerLiteral("123abc");
            fail("Creating an integer literal with letters should fail.");
        } catch (NumberFormatException nfe) {
            assertEquals(ErrorCode.NUMBER_CONTAINS_INVALID_CHARACTER, nfe.getErrorCode());
            
            String[] parameters = nfe.getParameters();
            assertEquals(2, parameters.length);
            assertEquals("123abc", parameters[0]);
            assertEquals("3", parameters[1]);
        }
    }
    
    @Test
    public void plain_number_is_recognized() {
        assertTrue(IntegerLiteral.isIntegerLiteral("123"));
    }
    
    @Test
    public void number_containing_decimal_is_not_recognized() {
        assertFalse(IntegerLiteral.isIntegerLiteral("123.4"));
    }
    
    @Test
    public void number_containing_letter_is_not_recognized() {
        assertFalse(IntegerLiteral.isIntegerLiteral("123e4"));
    }

    @Test
    public void number_containing_operator_is_not_recognized() {
        assertFalse(IntegerLiteral.isIntegerLiteral("123+4"));
    }
    
    @Test
    public void number_surrounded_by_whitespace_is_recognized() {
        assertTrue(IntegerLiteral.isIntegerLiteral(" 123\t\r\n"));
    }
}
