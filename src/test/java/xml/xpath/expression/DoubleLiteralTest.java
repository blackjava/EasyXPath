package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleLiteralTest {
    
    @Test
    public void plain_double_is_recognized() {
        assertTrue(DoubleLiteral.isDoubleLiteral("1e2"));
        assertTrue(DoubleLiteral.isDoubleLiteral("1e+2"));
        assertTrue(DoubleLiteral.isDoubleLiteral("1e-2"));
    }
    
    @Test
    public void double_with_decimals_is_recognized() {
        assertTrue(DoubleLiteral.isDoubleLiteral("1.2e3"));
        assertTrue(DoubleLiteral.isDoubleLiteral("1.2e+3"));
        assertTrue(DoubleLiteral.isDoubleLiteral("1.2e-3"));
    }
    
    @Test
    public void double_without_initial_digits_is_not_recognized() {
        assertFalse(DoubleLiteral.isDoubleLiteral("e2"));
        assertFalse(DoubleLiteral.isDoubleLiteral("e+2"));
        assertFalse(DoubleLiteral.isDoubleLiteral("e-2"));
    }

    @Test
    public void integer_is_not_recognized() {
        assertFalse(DoubleLiteral.isDoubleLiteral("123"));
    }

    @Test
    public void decimal_is_not_recognized() {
        assertFalse(DoubleLiteral.isDoubleLiteral("123.4"));
    }

    @Test
    public void double_with_letter_is_not_recognized() {
        assertFalse(DoubleLiteral.isDoubleLiteral("1e2e"));
    }

    @Test
    public void double_with_extra_operator_is_not_recognized() {
        assertFalse(DoubleLiteral.isDoubleLiteral("1e+2-"));
    }
}
