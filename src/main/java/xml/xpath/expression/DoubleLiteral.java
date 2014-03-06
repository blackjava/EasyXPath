package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class DoubleLiteral implements Expression {
    protected static final String DOUBLE_LITERAL_PATTERN = "(\\.[0-9]+|[0-9]+(\\.[0-9]*)?)[e|E][+|-]?[0-9]+";
    
    public DoubleLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_DOUBLE);
    }
    
    public static boolean isDoubleLiteral(String expression) {
        return expression.trim().matches(DOUBLE_LITERAL_PATTERN);
    }
}
