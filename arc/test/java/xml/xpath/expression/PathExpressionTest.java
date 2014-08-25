package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class PathExpressionTest {
    @Test
    public void relative_path_expression_containing_single_node_name_is_recognized() {
        assertTrue(PathExpression.isPathExpression("node"));
    }
    
    @Test
    public void relative_path_expression_containing_nested_node_name_is_recognized() {
        assertTrue(PathExpression.isPathExpression("node/child"));
    }
    
    @Test
    public void absolute_path_expression_containing_single_node_name_is_recognized() {
        assertTrue(PathExpression.isPathExpression("/node"));
    }

    @Test
    public void absolute_path_expression_containing_nested_node_name_is_recognized() {
        assertTrue(PathExpression.isPathExpression("/node/child"));
    }
    
    @Test
    public void search_path_expression_containing_nested_node_name_is_recognized() {
        assertTrue(PathExpression.isPathExpression("//node/child"));
    }

    @Test
    public void path_expression_containing_illegal_node_name_is_not_recognized() {
        assertFalse(PathExpression.isPathExpression("2node"));
    }

    @Test
    public void path_expression_containing_illegal_nested_node_name_is_not_recognized() {
        assertFalse(PathExpression.isPathExpression("node/2child"));
    }

    @Test
    public void path_expression_containing_backslash_character_is_not_recognized() {
        assertFalse(PathExpression.isPathExpression("node\\2child"));
    }
}
