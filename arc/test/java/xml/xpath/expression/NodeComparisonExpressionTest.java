package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class NodeComparisonExpressionTest {

    @Test
    public void is_node_comparison_test_is_recognized() {
        assertTrue(NodeComparisonExpression.isNodeComparisonExpression("is"));
    }

    @Test
    public void preceeding_node_comparison_test_is_recognized() {
        assertTrue(NodeComparisonExpression.isNodeComparisonExpression("<<"));
    }
    
    @Test
    public void following_node_comparison_test_is_recognized() {
        assertTrue(NodeComparisonExpression.isNodeComparisonExpression(">>"));
    }

    @Test
    public void equals_value_comparison_test_is_not_recognized() {
        assertFalse(NodeComparisonExpression.isNodeComparisonExpression("eq"));
    }
}