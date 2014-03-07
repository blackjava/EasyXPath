package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A decimal literal is a direct syntactic representation of a number with  
 * fractal parts.
 */
public class DecimalLiteral implements Expression {
    protected static final String DECIMAL_LITERAL_PATTERN = "(\\.[0-9]+|[0-9]+\\.[0-9]*)";
    
    public DecimalLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_DECIMAL);
    }
    
    public static boolean isDecimalLiteral(String expression) {
        return expression.trim().matches(DECIMAL_LITERAL_PATTERN);
    }
}
