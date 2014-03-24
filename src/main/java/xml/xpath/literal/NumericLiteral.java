package xml.xpath.literal;

import xml.xpath.UnsupportedExpressionException;
import static xml.xpath.literal.DecimalLiteral.DECIMAL_LITERAL_PATTERN;
import static xml.xpath.literal.DoubleLiteral.DOUBLE_LITERAL_PATTERN;
import static xml.xpath.literal.IntegerLiteral.INTEGER_LITERAL_PATTERN;

import i18n.ErrorCode;

/**
 * A numeric literal is a direct syntactic representation of an atomic number.
 * 
 * The value of a numeric literal containing no "." and no e or E character is 
 * an atomic value of type xs:integer. 
 * 
 * The value of a numeric literal containing "." but no e or E character is an 
 * atomic value of type xs:decimal. 
 * 
 * The value of a numeric literal containing an e or E character is an atomic 
 * value of type xs:double.
 */
public class NumericLiteral extends Literal {
    protected static final String NUMERIC_LITERAL_PATTERN = "(" + INTEGER_LITERAL_PATTERN + "|" + DECIMAL_LITERAL_PATTERN + "|" + DOUBLE_LITERAL_PATTERN + ")";
    
    public NumericLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_NUMERIC);
    }
    
    public static boolean isNumericLiteral(String expression) {
        return expression.trim().matches(NUMERIC_LITERAL_PATTERN);
    }
}
