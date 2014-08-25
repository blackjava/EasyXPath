package xml.xpath.nodetest;

import xml.xpath.nodetest.AnyKindTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnyKindTestTest {
    @Test
    public void empty_node_test_is_recognized() {
        assertTrue(AnyKindTest.isAnyKindTest("node()"));
    }

    @Test
    public void node_test_with_content_is_not_recognized() {
        assertFalse(AnyKindTest.isAnyKindTest("node(name)"));
    }

    @Test
    public void node_test_without_parenthesis_is_not_recognized() {
        assertFalse(AnyKindTest.isAnyKindTest("node"));
    }
    
    @Test
    public void function_is_not_recognized() {
        assertFalse(AnyKindTest.isAnyKindTest("function()"));
    }
}