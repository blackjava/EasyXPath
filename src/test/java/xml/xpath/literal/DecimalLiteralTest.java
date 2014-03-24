package xml.xpath.literal;

import xml.xpath.literal.DecimalLiteral;
import i18n.ErrorCode;
import org.junit.Test;
import xml.xpath.NumberFormatException;
import static org.junit.Assert.*;

public class DecimalLiteralTest {
    @Test
    public void empty_string_results_in_number_format_exception() {
        try {
            new DecimalLiteral("");
            fail("Creating a decimal literal with an empty string should fail.");
        } catch (NumberFormatException nfe) {
            assertEquals(ErrorCode.COULD_NOT_PARSE_DECIMAL, nfe.getErrorCode());
            
            String[] parameters = nfe.getParameters();
            assertEquals(1, parameters.length);
            assertEquals("", parameters[0]);
        }
    }

    @Test
    public void integer_value_is_properly_parsed() {
        DecimalLiteral literal = new DecimalLiteral("123");
        assertEquals("123.0", literal.toString());
    }
    
    @Test
    public void decimal_value_is_properly_parsed() {
        DecimalLiteral literal = new DecimalLiteral("123.4");
        assertEquals("123.4", literal.toString());
    }

    @Test
    public void string_results_in_number_format_exception() {
        try {
            new DecimalLiteral("123abc");
            fail("Creating a decimal literal with invalid characters should fail.");
        } catch (NumberFormatException nfe) {
            assertEquals(ErrorCode.NUMBER_CONTAINS_INVALID_CHARACTER, nfe.getErrorCode());
            
            String[] parameters = nfe.getParameters();
            assertEquals(2, parameters.length);
            assertEquals("123abc", parameters[0]);
            assertEquals("3", parameters[1]);
        }
    }
    
    @Test
    public void number_with_decimals_is_recognized() {
        assertTrue(DecimalLiteral.isDecimalLiteral("123.4"));
    }
    
    @Test
    public void number_with_period_but_no_decimals_is_recognized() {
        assertTrue(DecimalLiteral.isDecimalLiteral("123."));
    }

    @Test
    public void number_with_decimals_only_is_recognized() {
        assertTrue(DecimalLiteral.isDecimalLiteral(".4"));
    }

    @Test
    public void number_without_period_is_not_recognized() {
        assertFalse(DecimalLiteral.isDecimalLiteral("1234"));
    }

    @Test
    public void number_with_two_periods_is_not_recognized() {
        assertFalse(DecimalLiteral.isDecimalLiteral("12.3.4"));
    }

    @Test
    public void number_with_letter_is_not_recognized() {
        assertFalse(DecimalLiteral.isDecimalLiteral("123e4"));
    }

    @Test
    public void number_with_operator_is_not_recognized() {
        assertFalse(DecimalLiteral.isDecimalLiteral("123+4"));
    }

    @Test
    public void decimal_surrounded_by_whitespace_is_recognized() {
        assertTrue(DecimalLiteral.isDecimalLiteral(" 123.4\t\r\n"));
    }
}
