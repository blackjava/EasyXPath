package xml.xpath.nodetest;

import xml.xpath.nodetest.AttributeTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class AttributeTestTest {
    @Test
    public void empty_attribute_test_is_recognized() {
        assertTrue(AttributeTest.isAttributeTest("attribute()"));
    }

    @Test
    public void attribute_test_with_name_is_recognized() {
        assertTrue(AttributeTest.isAttributeTest("attribute(name)"));
    }

    @Test
    public void attribute_test_with_wildcard_is_recognized() {
        assertTrue(AttributeTest.isAttributeTest("attribute(*)"));
    }

    @Test
    public void attribute_test_with_name_and_type_is_recognized() {
        assertTrue(AttributeTest.isAttributeTest("attribute(name,xs:string)"));
    }

    @Test
    public void attribute_test_with_wildcard_and_type_is_recognized() {
        assertTrue(AttributeTest.isAttributeTest("attribute(*,xs:string)"));
    }
    
    @Test
    public void attribute_test_with_incorrect_number_of_arguments_is_not_recognized() {
        assertFalse(AttributeTest.isAttributeTest("attribute(namespace,name,xs:string)"));
    }
}
