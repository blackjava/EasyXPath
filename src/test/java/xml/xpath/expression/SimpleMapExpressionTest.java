package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleMapExpressionTest {

    @Test
    public void plain_simple_map_expression_is_recognized() {
        assertTrue(SimpleMapExpression.isSimpleMapExpression("//node ! node"));
    }
    
    @Test
    public void simple_map_expression_without_operator_is_not_recognized() {
        assertFalse(SimpleMapExpression.isSimpleMapExpression("node node"));
    }

    @Test
    public void simple_map_expression_with_only_one_path_is_not_recognized() {
        assertFalse(SimpleMapExpression.isSimpleMapExpression("node ! "));
        assertFalse(SimpleMapExpression.isSimpleMapExpression(" ! node"));
    }
}
