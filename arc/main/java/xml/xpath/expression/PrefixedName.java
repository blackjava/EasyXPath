package xml.xpath.expression;

import xml.xpath.literal.Literal;
import xml.xpath.UnsupportedExpressionException;
import static xml.xpath.expression.NCName.NCNAME_PATTERN;

import i18n.ErrorCode;

/**
 * A prefixed name is a name with a defined namespace. The prefix provides the 
 * namespace, and MUST be associated with a namespace URI reference in the 
 * namespace declaration.
 */
public class PrefixedName extends Literal {
    protected static final String PREFIXED_NAME_PATTERN = NCNAME_PATTERN + "\\:" + NCNAME_PATTERN;
    
    public PrefixedName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_PREFIXEDNAME);
    }
    
    public static boolean isPrefixedName(String expression) {
        return expression.matches(PREFIXED_NAME_PATTERN);
    }
}
