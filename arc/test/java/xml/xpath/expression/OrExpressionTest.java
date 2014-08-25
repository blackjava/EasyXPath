package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrExpressionTest {
    
    @Test
    public void plain_expression_without_or_is_recognized() {
        assertTrue(OrExpression.isOrExpression("."));
    }

    @Test
    public void plain_expression_with_or_is_recognized() {
        assertTrue(OrExpression.isOrExpression(". or ."));
    }

}
