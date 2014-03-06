package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumericLiteralTest {
    
    @Test
    public void integer_with_whitespace_is_recognized() {
        assertTrue(NumericLiteral.isNumericLiteral(" 123\t\r\n"));
    }
    
    @Test
    public void decimal_with_whitespace_is_recognized() {
        assertTrue(NumericLiteral.isNumericLiteral(" 123.4\t\r\n"));
    }

    @Test
    public void double_with_whitespace_is_recognized() {
        assertTrue(NumericLiteral.isNumericLiteral(" 1.2e+3\t\r\n"));
    }

    @Test
    public void text_is_not_recognized() {
        assertFalse(NumericLiteral.isNumericLiteral("abc"));
    }

    @Test
    public void whitespace_is_not_recognized() {
        assertFalse(NumericLiteral.isNumericLiteral(" \t\r\n"));
    }

    @Test
    public void multiple_numbers_is_not_recognized() {
        assertFalse(NumericLiteral.isNumericLiteral("1 2 3"));
    }
}
