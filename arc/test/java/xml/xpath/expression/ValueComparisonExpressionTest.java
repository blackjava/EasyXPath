package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValueComparisonExpressionTest {

    @Test
    public void equals_value_comparison_expression_is_recognized() {
        assertTrue(ValueComparisonExpression.isValueComparisonExpression("eq"));
    }

    @Test
    public void not_equals_value_comparison_expression_is_recognized() {
        assertTrue(ValueComparisonExpression.isValueComparisonExpression("ne"));
    }

    @Test
    public void less_than_value_comparison_expression_is_recognized() {
        assertTrue(ValueComparisonExpression.isValueComparisonExpression("lt"));
    }

    @Test
    public void less_or_equal_value_comparison_expression_is_recognized() {
        assertTrue(ValueComparisonExpression.isValueComparisonExpression("le"));
    }

    @Test
    public void greater_than_value_comparison_expression_is_recognized() {
        assertTrue(ValueComparisonExpression.isValueComparisonExpression("gt"));
    }

    @Test
    public void greater_or_equal_value_comparison_expression_is_recognized() {
        assertTrue(ValueComparisonExpression.isValueComparisonExpression("ge"));
    }

    @Test
    public void invalid_value_comparison_expression_is_recognized() {
        assertFalse(ValueComparisonExpression.isValueComparisonExpression("xx"));
    }
}