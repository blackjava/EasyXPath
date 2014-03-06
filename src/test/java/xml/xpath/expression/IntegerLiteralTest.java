package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerLiteralTest {

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
