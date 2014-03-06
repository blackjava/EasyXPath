package xml.xpath.expression;

import static xml.xpath.expression.NumericLiteral.NUMERIC_LITERAL_PATTERN;
import static xml.xpath.expression.StringLiteral.STRING_LITERAL_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class Literal implements Expression {
    private static final String LITERAL_PATTERN = "(" + NUMERIC_LITERAL_PATTERN + "|" + STRING_LITERAL_PATTERN + ")";
    
    public Literal() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL);
    }
    
    public static boolean isLiteral(String expression) {
        return expression.trim().matches(LITERAL_PATTERN);
    }
}
