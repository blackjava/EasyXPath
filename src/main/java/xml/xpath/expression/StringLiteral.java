package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class StringLiteral implements Expression {
    private static final String STRING_LITERAL_PATTERN = "(\\\"([^\\\"]|\\\\\\\"|\\\"\\\")*\\\"|\\'([^\\']|\\\\\\'|\\'\\')*\\')";
    
    public StringLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_STRING);
    }
    
    public static boolean isStringLiteral(String expression) {
        return expression.trim().matches(STRING_LITERAL_PATTERN);
    }
}
