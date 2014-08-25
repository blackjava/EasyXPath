package xml.xpath.literal;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;

/**
 * A double literal is a direct syntactic representation of an exponential 
 * number. In a double literal, 'E' or 'e' is used as an abbreviated form of 
 * writing x10^n, i.e. '1e+2' translates to '1 x 10^2'.
 */
public class DoubleLiteral extends Literal {
    protected static final String DOUBLE_LITERAL_PATTERN = "(\\.[0-9]+|[0-9]+(\\.[0-9]*)?)[e|E][+|-]?[0-9]+";
    
    public DoubleLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_DOUBLE);
    }
    
    public static boolean isDoubleLiteral(String expression) {
        return expression.trim().matches(DOUBLE_LITERAL_PATTERN);
    }
}
