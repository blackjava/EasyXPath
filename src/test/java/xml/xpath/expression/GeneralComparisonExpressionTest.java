package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class GeneralComparisonExpressionTest {

    @Test
    public void equals_general_comparison_expression_is_recognized() {
        assertTrue(GeneralComparisonExpression.isGeneralComparisonExpression("="));
    }

    @Test
    public void not_equals_general_comparison_expression_is_recognized() {
        assertTrue(GeneralComparisonExpression.isGeneralComparisonExpression("!="));
    }

    @Test
    public void less_than_general_comparison_expression_is_recognized() {
        assertTrue(GeneralComparisonExpression.isGeneralComparisonExpression("<"));
    }

    @Test
    public void less_than_or_equal_general_comparison_expression_is_recognized() {
        assertTrue(GeneralComparisonExpression.isGeneralComparisonExpression("<="));
    }

    @Test
    public void greater_than_general_comparison_expression_is_recognized() {
        assertTrue(GeneralComparisonExpression.isGeneralComparisonExpression(">"));
    }

    @Test
    public void greater_than_or_equal_general_comparison_expression_is_recognized() {
        assertTrue(GeneralComparisonExpression.isGeneralComparisonExpression(">="));
    }
}