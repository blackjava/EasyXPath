package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValueExpressionTest {
    @Test
    public void text_value_expression_is_recognized() {
        assertTrue(ValueExpression.isValueExpression("node"));
    }

    @Test
    public void numeric_value_expression_is_recognized() {
        assertTrue(ValueExpression.isValueExpression("123"));
    }
    
    @Test
    public void mapped_value_expression_is_recognized() {
        assertTrue(ValueExpression.isValueExpression("//node ! node"));
    }
    
    @Test
    public void value_expression_with_twooperands_is_not_recognized() {
        assertFalse(ValueExpression.isValueExpression("node node"));
    }

    @Test
    public void mapped_value_expression_with_only_one_operand_is_not_recognized() {
        assertFalse(ValueExpression.isValueExpression("node ! "));
        assertFalse(ValueExpression.isValueExpression(" ! node"));
    }
}
