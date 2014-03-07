package xml.xpath.expression;

import static xml.xpath.expression.NCName.NCNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A prefixed name is a name with a defined namespace. The prefix provides the 
 * namespace, and MUST be associated with a namespace URI reference in the 
 * namespace declaration.
 */
public class PrefixedName implements Expression {
    protected static final String PREFIXED_NAME_PATTERN = NCNAME_PATTERN + "\\:" + NCNAME_PATTERN;
    
    public PrefixedName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_PREFIXEDNAME);
    }
    
    public static boolean isPrefixedName(String expression) {
        return expression.matches(PREFIXED_NAME_PATTERN);
    }
}
