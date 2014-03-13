package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextTestTest {
    @Test
    public void text_test_is_recognized() {
        assertTrue(TextTest.isTextTest("text()"));
    }

    @Test
    public void text_test_with_parameter_is_not_recognized() {
        assertFalse(TextTest.isTextTest("text(param)"));
    }
    
    @Test
    public void text_is_not_recognized() {
        assertFalse(TextTest.isTextTest("text"));
    }

    @Test
    public void function_is_not_recognized() {
        assertFalse(TextTest.isTextTest("function()"));
    }
}