package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A for expression iterates over a set of items, evaluating an expression on 
 * each of them.
 */
public class ForExpression implements Expression {
    private static final String FOR_EXPRESSION_PATTERN = "for \\$.+ in .+ return .+";
    
    public ForExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_FOR);
    }
   
    /**
     * Determines if the specified string is a for expression.
     */
    public static boolean isForExpression(String expression) {
        return expression.matches(FOR_EXPRESSION_PATTERN);
    }
}
