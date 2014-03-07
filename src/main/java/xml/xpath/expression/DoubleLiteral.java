package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A double literal is a direct syntactic representation of an exponential 
 * number. In a double literal, 'E' or 'e' is used as an abbreviated form of 
 * writing x10^n, i.e. '1e+2' translates to '1 x 10^2'.
 */
public class DoubleLiteral implements Expression {
    protected static final String DOUBLE_LITERAL_PATTERN = "(\\.[0-9]+|[0-9]+(\\.[0-9]*)?)[e|E][+|-]?[0-9]+";
    
    public DoubleLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_DOUBLE);
    }
    
    public static boolean isDoubleLiteral(String expression) {
        return expression.trim().matches(DOUBLE_LITERAL_PATTERN);
    }
}
