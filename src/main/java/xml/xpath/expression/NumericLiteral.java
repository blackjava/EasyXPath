package xml.xpath.expression;

import static xml.xpath.expression.DecimalLiteral.DECIMAL_LITERAL_PATTERN;
import static xml.xpath.expression.DoubleLiteral.DOUBLE_LITERAL_PATTERN;
import static xml.xpath.expression.IntegerLiteral.INTEGER_LITERAL_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class NumericLiteral implements Expression {
    private static final String NUMERIC_LITERAL_PATTERN = "(" + INTEGER_LITERAL_PATTERN + "|" + DECIMAL_LITERAL_PATTERN + "|" + DOUBLE_LITERAL_PATTERN + ")";
    
    public NumericLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_NUMERIC);
    }
    
    public static boolean isNumericLiteral(String expression) {
        return expression.trim().matches(NUMERIC_LITERAL_PATTERN);
    }
}
