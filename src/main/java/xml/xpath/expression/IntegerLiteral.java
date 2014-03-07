package xml.xpath.expression;

import i18n.ErrorCode;

/**
 * An integer literal is a direct syntactic representation of a number with no 
 * fractal parts.
 */
public class IntegerLiteral extends Literal {
    protected static final String INTEGER_LITERAL_PATTERN = "[0-9]+";
    
    public IntegerLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_INTEGER);
    }
    
    public static boolean isIntegerLiteral(String expression) {
        return expression.trim().matches(INTEGER_LITERAL_PATTERN);
    }
}
