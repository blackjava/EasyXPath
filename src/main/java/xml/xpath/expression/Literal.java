package xml.xpath.expression;

import static xml.xpath.expression.NumericLiteral.NUMERIC_LITERAL_PATTERN;
import static xml.xpath.expression.StringLiteral.STRING_LITERAL_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A literal is a direct syntactic representation of an atomic value. 
 * 
 * XPath 3.0 supports two kinds of literals: numeric literals and string 
 * literals.
 */
public class Literal implements Expression {
    protected static final String LITERAL_PATTERN = "(" + NUMERIC_LITERAL_PATTERN + "|" + STRING_LITERAL_PATTERN + ")";
    
    public static boolean isLiteral(String expression) {
        return expression.trim().matches(LITERAL_PATTERN);
    }
}
