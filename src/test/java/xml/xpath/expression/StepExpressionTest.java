package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class StepExpressionTest {
    @Test
    public void path_with_separators_is_not_recognized() {
        assertFalse(StepExpression.isStepExpression("node/child"));
    }
    
}
