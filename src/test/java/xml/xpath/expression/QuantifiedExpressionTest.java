package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantifiedExpressionTest {
    
    @Test
    public void plain_some_quantified_expression_is_recognized() {
        assertTrue(QuantifiedExpression.isQuantifiedExpression("some $var in . satisfies ."));
    }

    @Test
    public void plain_every_quantified_expression_is_recognized() {
        assertTrue(QuantifiedExpression.isQuantifiedExpression("every $var in . satisfies ."));
    }
    
    @Test
    public void quantified_expression_without_quantifier_is_not_recognized() {
        assertFalse(QuantifiedExpression.isQuantifiedExpression("$var in . satisfies ."));
    }

    @Test
    public void quantified_expression_without_in_is_not_recognized() {
        assertFalse(QuantifiedExpression.isQuantifiedExpression("some $var . satisfies ."));
    }
    
    @Test
    public void quantified_expression_without_satisfies_is_not_recognized() {
        assertFalse(QuantifiedExpression.isQuantifiedExpression("some $var in ."));
    }
}
