package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class RelativePathExpressionTest {

    @Test
    public void relative_path_expression_containing_current_node_is_recognized() {
        assertTrue(RelativePathExpression.isRelativePathExpression("."));
    }
    
    @Test
    public void relative_path_expression_containing_single_node_name_is_recognized() {
        assertTrue(RelativePathExpression.isRelativePathExpression("node"));
    }
    
    @Test
    public void relative_path_expression_containing_nested_node_name_is_recognized() {
        assertTrue(RelativePathExpression.isRelativePathExpression("node/child"));
    }

    @Test
    public void relative_path_expression_containing_search_for_node_name_is_recognized() {
        assertTrue(RelativePathExpression.isRelativePathExpression("node//child"));
    }
    
    @Test
    public void absolute_path_expression_containing_single_node_name_is_not_recognized() {
        assertFalse(RelativePathExpression.isRelativePathExpression("/node"));
    }

    @Test
    public void absolute_path_expression_containing_nested_node_name_is_not_recognized() {
        assertFalse(RelativePathExpression.isRelativePathExpression("/node/child"));
    }
    
    @Test
    public void search_path_expression_containing_nested_node_name_is_not_recognized() {
        assertFalse(RelativePathExpression.isRelativePathExpression("//node/child"));
    }

    @Test
    public void path_expression_containing_illegal_node_name_is_not_recognized() {
        assertFalse(RelativePathExpression.isRelativePathExpression("2node"));
    }

    @Test
    public void path_expression_containing_illegal_nested_node_name_is_not_recognized() {
        assertFalse(RelativePathExpression.isRelativePathExpression("node/2child"));
    }

    @Test
    public void path_expression_containing_backslash_character_is_not_recognized() {
        assertFalse(RelativePathExpression.isRelativePathExpression("node\\2child"));
    }
}
