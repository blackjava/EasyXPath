package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A let expression declares a variable and binds it to a value.
 */
public class LetExpression implements Expression {
    protected static final String LET_EXPRESSION_PATTERN = "let \\$.+ := .+ return .+";
    
    public LetExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_LET);
    }
    
    /**
     * Determines if the specified string is a let expression.
     */
    public static boolean isLetExpression(String expression) {
        return expression.matches(LET_EXPRESSION_PATTERN);
    }
}
