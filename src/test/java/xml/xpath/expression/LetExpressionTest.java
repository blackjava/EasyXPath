package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class LetExpressionTest {

    @Test
    public void plain_let_expression_is_recognized() {
        assertTrue(LetExpression.isLetExpression("let $var := . return ."));
    }

    @Test
    public void let_expression_without_let_is_not_recognized() {
        assertFalse(LetExpression.isLetExpression("$var := . return ."));
    }

    @Test
    public void let_expression_without_assignment_is_not_recognized() {
        assertFalse(LetExpression.isLetExpression("let $var . return ."));
    }
    
    @Test
    public void for_expression_without_return_is_not_recognized() {
        assertFalse(LetExpression.isLetExpression("let $var := ."));
    }
}
