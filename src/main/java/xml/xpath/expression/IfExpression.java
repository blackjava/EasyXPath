package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * An if expression evaluates an expression to a boolean value, and then invokes 
 * one of two expressions based on its result. If the expression evaluates to 
 * true, the expression following the then keyword is invoked, otherwise the 
 * expression following the else keyword is invoked.
 */
public class IfExpression implements Expression {
    private static final String IF_EXPRESSION_PATTERN = "if (.+) then .+ else .+";
    
    public IfExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_IF);
    }
    
    /**
     * Determines if the specified string is an if expression.
     */
    public static boolean isIfExpression(String expression) {
        return expression.matches(IF_EXPRESSION_PATTERN);
    }
}
