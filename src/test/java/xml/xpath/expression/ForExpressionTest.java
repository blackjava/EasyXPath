package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ForExpressionTest {

    @Test
    public void plain_for_expression_is_recognized() {
        assertTrue(ForExpression.isForExpression("for $var in . return ."));
    }

    @Test
    public void for_expression_without_for_is_not_recognized() {
        assertFalse(ForExpression.isForExpression("$var in . return ."));
    }

    @Test
    public void for_expression_without_in_is_not_recognized() {
        assertFalse(ForExpression.isForExpression("for $var . return ."));
    }
    
    @Test
    public void for_expression_without_return_is_not_recognized() {
        assertFalse(ForExpression.isForExpression("for $var in ."));
    }
}
