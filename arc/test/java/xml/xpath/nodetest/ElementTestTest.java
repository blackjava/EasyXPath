package xml.xpath.nodetest;

import org.junit.Test;
import static org.junit.Assert.*;

public class ElementTestTest {
    @Test
    public void empty_element_test_is_recognized() {
        assertTrue(ElementTest.isElementTest("element()"));
    }

    @Test
    public void element_test_with_wildcard_is_recognized() {
        assertTrue(ElementTest.isElementTest("element(*)"));
    }
    
    @Test
    public void element_test_with_name_is_recognized() {
        assertTrue(ElementTest.isElementTest("element(name)"));
    }

    @Test
    public void element_test_with_invalid_name_is_not_recognized() {
        assertFalse(ElementTest.isElementTest("element(na me)"));
    }

    @Test
    public void element_test_with_wildcard_and_type_is_recognized() {
        assertTrue(ElementTest.isElementTest("element(*,type)"));
    }
    
    @Test
    public void element_test_with_name_and_type_is_recognized() {
        assertTrue(ElementTest.isElementTest("element(name,type)"));
    }

    @Test
    public void element_test_with_wildcard_and_type_and_ignorenilled_flag_is_recognized() {
        assertTrue(ElementTest.isElementTest("element(*,type?)"));
    }

    @Test
    public void element_test_with_name_and_type_and_ignorenilled_flag_is_recognized() {
        assertTrue(ElementTest.isElementTest("element(name,type?)"));
    }
}