package xml.xpath.expression;

import static xml.xpath.expression.CastExpression.CASTEXPRESSION_PATTERN;
import static xml.xpath.expression.SingleType.SINGLETYPE_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

public class CastableExpression implements Expression {
    private static final String CASTABLEEXPRESSION_PATTERN = CASTEXPRESSION_PATTERN + "( castable as " + SINGLETYPE_PATTERN + ")?";
    
    public CastableExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_CASTABLEEXPRESSION);
    }
    
    public static boolean isCastableExpression(String expression) {
        return expression.matches(CASTABLEEXPRESSION_PATTERN);
    }
}
