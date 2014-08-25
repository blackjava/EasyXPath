package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionSingleTest {

    @Test
    public void for_expression_is_recognized() {
        assertTrue(ExpressionSingle.isExpressionSingle("for $var in . return ."));
    }

    @Test
    public void let_expression_is_recognized() {
        assertTrue(ExpressionSingle.isExpressionSingle("let $var := . return ."));
    }

    @Test
    public void quantified_expression_is_recognized() {
        assertTrue(ExpressionSingle.isExpressionSingle("some $var in . satisfies ."));
    }

    @Test
    public void if_expression_is_recognized() {
        assertTrue(ExpressionSingle.isExpressionSingle("if (.) then . else ."));
    }

    @Test
    public void or_expression_is_recognized() {
        assertTrue(ExpressionSingle.isExpressionSingle(". or ."));
    }

    @Test
    public void comma_separated_expression_is_not_recognized() {
        assertFalse(ExpressionSingle.isExpressionSingle("if (.) then . else ., . or ."));
    }
}