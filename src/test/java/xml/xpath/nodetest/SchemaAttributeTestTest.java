package xml.xpath.nodetest;

import org.junit.Test;
import static org.junit.Assert.*;

public class SchemaAttributeTestTest {
    @Test
    public void valid_schema_attribute_test_is_recognized() {
        assertTrue(SchemaAttributeTest.isSchemaAttributeTest("schema-attribute(name)"));
    }

    @Test
    public void empty_schema_attribute_test_is_not_recognized() {
        assertFalse(SchemaAttributeTest.isSchemaAttributeTest("schema-attribute()"));
    }

    @Test
    public void schema_attribute_test_containing_string_is_not_recognized() {
        assertFalse(SchemaAttributeTest.isSchemaAttributeTest("schema-attribute(\"name\")"));
        assertFalse(SchemaAttributeTest.isSchemaAttributeTest("schema-attribute('name')"));
    }
}