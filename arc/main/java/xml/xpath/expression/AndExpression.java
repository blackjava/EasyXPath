package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * An and expression evaluates to true if the effective boolean value of all of 
 * its operands is true. Otherwise the and expression evaluates to false.
 */
public class AndExpression implements Expression {
    protected static final String AND_EXPRESSION_PATTERN = ".+( and .+)*";
    
    public AndExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_AND);
    }

    public static boolean isAndExpression(String expression) {
        return expression.matches(AND_EXPRESSION_PATTERN);
    }
}
