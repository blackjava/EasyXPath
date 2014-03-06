package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class DecimalLiteralTest {

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
