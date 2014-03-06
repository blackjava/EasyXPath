package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class IntegerLiteral implements Expression {
    protected static final String INTEGER_LITERAL_PATTERN = "[0-9]+";
    
    public IntegerLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_INTEGER);
    }
    
    public static boolean isIntegerLiteral(String expression) {
        return expression.trim().matches(INTEGER_LITERAL_PATTERN);
    }
}
