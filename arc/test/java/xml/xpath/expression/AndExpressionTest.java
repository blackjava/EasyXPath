package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class AndExpressionTest {

    @Test
    public void plain_expression_without_and_is_recognized() {
        assertTrue(AndExpression.isAndExpression("."));
    }
    
    @Test
    public void plain_expression_with_and_is_recognized() {
        assertTrue(AndExpression.isAndExpression(". and ."));
    }

}