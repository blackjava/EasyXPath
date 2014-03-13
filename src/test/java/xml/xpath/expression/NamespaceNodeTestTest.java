package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class NamespaceNodeTestTest {
    @Test
    public void namespace_node_test_is_recognized() {
        assertTrue(NamespaceNodeTest.isNamespaceNodeTest("namespace-node()"));
    }
    
    @Test
    public void function_is_not_recognized() {
        assertFalse(NamespaceNodeTest.isNamespaceNodeTest("namespacenode()"));
    }
}
