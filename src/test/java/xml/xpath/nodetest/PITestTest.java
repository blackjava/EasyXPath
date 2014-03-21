package xml.xpath.nodetest;

import org.junit.Test;
import static org.junit.Assert.*;

public class PITestTest {
    @Test
    public void empty_pi_test_is_recognized() {
        assertTrue(PITest.isPITest("processing-instruction()"));
    }
    
    @Test
    public void pi_test_with_ncname_is_recognized() {
        assertTrue(PITest.isPITest("processing-instruction(xml-stylesheet)"));
    }

    @Test
    public void pi_test_with_string_literal_is_recognized() {
        assertTrue(PITest.isPITest("processing-instruction(\"xml-stylesheet\")"));
        assertTrue(PITest.isPITest("processing-instruction('xml-stylesheet')"));
    }
    
    @Test
    public void pi_test_without_parenthesis_is_not_recognized() {
        assertFalse(PITest.isPITest("processing-instruction"));
    }

    @Test
    public void pi_test_with_invalid_ncname_is_not_recognized() {
        assertFalse(PITest.isPITest("processing-instruction(invalid nc:name)"));
    }

    @Test
    public void pi_test_with_invalid_string_literal_is_not_recognized() {
        assertFalse(PITest.isPITest("processing-instruction(\"invalid string')"));
    }
    
    @Test
    public void function_is_not_recognized() {
        assertFalse(PITest.isPITest("function()"));
    }
}