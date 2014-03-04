package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class IntegerLiteral implements Expression {
    private static final String INTEGER_LITERAL_PATTERN = "[0-9]*";
    
    public IntegerLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_INTEGER);
    }
    
    public static boolean isIntegerLiteral(String expression) {
        return expression.matches(INTEGER_LITERAL_PATTERN);
    }
}
