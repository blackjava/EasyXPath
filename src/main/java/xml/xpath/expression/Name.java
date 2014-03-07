package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A Name is a Nmtoken with a restricted set of initial characters. Disallowed 
 * initial characters for Names include digits, diacritics, the full stop and 
 * the hyphen.
 * 
 * Characters in the compatibility area (i.e. with character code greater than 
 * #xF900 and less than #xFFFE) are not allowed in XML names.
 * 
 * The Namespaces in XML Recommendation [XML Names] assigns a meaning to names 
 * containing colon characters. Therefore, authors should not use the colon in 
 * XML names except for namespace purposes, but XML processors must accept the 
 * colon as a name character.
 */
public class Name implements Expression {
    private static final String NAME_START_CHARACTER = "(\\:|[A-Z]|\\_|[a-z]|[\\x{C0}-\\x{D6}]|[\\x{D8}-\\x{F6}]|[\\x{F8}-\\x{2FF}]|[\\x{370}-\\x{37D}]|[\\x{37F}-\\x{1FFF}]|[\\x{200C}-\\x{200D}]|[\\x{2070}-\\x{218F}]|[\\x{2C00}-\\x{2FEF}]|[\\x{3001}-\\x{D7FF}]|[\\x{F900}-\\x{FDCF}]|[\\x{FDF0}-\\x{FFFD}]|[\\x{10000}-\\x{EFFFF}])";
    private static final String NAME_CHARACTER = "(" + Name.NAME_START_CHARACTER + "|\\-|\\.|[0-9]|\\x{B7}|[\\x{0300}-\\x{036F}|[\\x{203F}-\\x{2040}]])";
    private static final String NAME_PATTERN = Name.NAME_START_CHARACTER + NAME_CHARACTER + "*";
    
    public Name() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_NAME);
    }
    
    public static boolean isName(String expression) {
        return expression.matches(NAME_PATTERN);
    }
}
