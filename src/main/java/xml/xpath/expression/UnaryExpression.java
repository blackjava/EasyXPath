package xml.xpath.expression;

import static xml.xpath.expression.SimpleMapExpression.SIMPLE_MAP_EXPRESSION_PATTERN;

import i18n.ErrorCode;
import xml.xpath.UnsupportedExpressionException;

/**
 * A unary expression is an operand used in an arithmetic expression. It is used
 * to indicate whether a value is negative or positive.
 */
public class UnaryExpression {
    private static final String UNARYEXPRESSION_PATTERN = "(\\-|\\+)*" + SIMPLE_MAP_EXPRESSION_PATTERN;
    
    public UnaryExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_UNARYEXPRESSION);
    }
    
    public static boolean isUnaryExpression(String expression) {
        return expression.matches(UNARYEXPRESSION_PATTERN);
    }
}
