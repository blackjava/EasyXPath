package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class DecimalLiteral implements Expression {
    private static final String DECIMAL_LITERAL_PATTERN = "(\\.[0-9]+|[0-9]+\\.[0-9]*)";
    
    public DecimalLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_DECIMAL);
    }
    
    public static boolean isDecimalLiteral(String expression) {
        return expression.matches(DECIMAL_LITERAL_PATTERN);
    }
}
