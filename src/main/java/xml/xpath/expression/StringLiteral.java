package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A string literal is a direct syntactic representation of an atomic string.
 * 
 * The value of a string literal is an atomic value whose type is xs:string and 
 * whose value is the string denoted by the characters between the delimiting 
 * apostrophes or quotation marks. 
 * 
 * If the literal is delimited by apostrophes, two adjacent apostrophes within 
 * the literal are interpreted as a single apostrophe. Similarly, if the literal 
 * is delimited by quotation marks, two adjacent quotation marks within the 
 * literal are interpreted as one quotation mark.
 */
public class StringLiteral implements Expression {
    protected static final String STRING_LITERAL_PATTERN = "(\\\"([^\\\"]|\\\\\\\"|\\\"\\\")*\\\"|\\'([^\\']|\\\\\\'|\\'\\')*\\')";
    
    public StringLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_STRING);
    }
    
    public static boolean isStringLiteral(String expression) {
        return expression.trim().matches(STRING_LITERAL_PATTERN);
    }
}
