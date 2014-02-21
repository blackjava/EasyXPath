package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrExpressionTest {
    
    @Test
    public void plain_or_expression_is_recognized() {
        assertTrue(OrExpression.isOrExpression(". or ."));
    }

    @Test
    public void or_expression_without_or_is_not_recognized() {
        assertFalse(OrExpression.isOrExpression("."));
    }
}
