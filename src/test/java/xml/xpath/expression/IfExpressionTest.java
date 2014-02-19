package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class IfExpressionTest {
    @Test
    public void plain_if_expression_is_recognized() {
        assertTrue(IfExpression.isIfExpression("if (.) then . else ."));
    }

    @Test
    public void if_expression_without_if_is_not_recognized() {
        assertFalse(IfExpression.isIfExpression("(.) then . else ."));
    }

    @Test
    public void if_expression_without_then_is_not_recognized() {
        assertFalse(IfExpression.isIfExpression("if (.) . else ."));
    }
    
    @Test
    public void if_expression_without_else_is_not_recognized() {
        assertFalse(IfExpression.isIfExpression("if (.) then ."));
    }
}
