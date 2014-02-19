package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * An or expression evaluates to true if the effective boolean value of any of 
 * its operands is true. Otherwise the or expression evaluates to false.
 */
public class OrExpression implements Expression {
    private static final String OR_EXPRESSION_PATTERN = ".+( or .+)*";
    
    public OrExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_OR);
    }
    
    /**
     * Determines if the specified string is an or expression.
     */
    public static boolean isOrExpression(String expression) {
        return expression.matches(OR_EXPRESSION_PATTERN);
    }
}
