package xml.xpath.nodetest;

import org.junit.Test;
import static org.junit.Assert.*;

public class KindTestTest {
    @Test
    public void anykindtest_is_recognized() {
        assertTrue(KindTest.isKindTest("node()"));
    }

    @Test
    public void attributetest_is_recognized() {
        assertTrue(KindTest.isKindTest("attribute()"));
    }

    @Test
    public void commenttest_is_recognized() {
        assertTrue(KindTest.isKindTest("comment()"));
    }

    @Test
    public void documenttest_is_recognized() {
        assertTrue(KindTest.isKindTest("document-node()"));
    }
    
    @Test
    public void elementtest_is_recognized() {
        assertTrue(KindTest.isKindTest("element()"));
    }

    @Test
    public void namespacenodetest_is_recognized() {
        assertTrue(KindTest.isKindTest("namespace-node()"));
    }

    @Test
    public void pitest_is_recognized() {
        assertTrue(KindTest.isKindTest("processing-instruction()"));
    }
    
    @Test
    public void schemaattributetest_is_recognized() {
        assertTrue(KindTest.isKindTest("schema-attribute(name)"));
    }

    @Test
    public void schemaelementtest_is_recognized() {
        assertTrue(KindTest.isKindTest("schema-element(name)"));
    }
    
    @Test
    public void texttest_is_recognized() {
        assertTrue(KindTest.isKindTest("text()"));
    }

    @Test
    public void function_is_not_recognized() {
        assertFalse(KindTest.isKindTest("function()"));
    }
}