package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import static xml.xpath.expression.NCName.NCNAME_PATTERN;
import static xml.xpath.expression.PrefixedName.PREFIXED_NAME_PATTERN;

import i18n.ErrorCode;

/**
 * QName is a qualified name. A qualified name is an XML name optionally 
 * prefixed with a namespace.
 */
public class QName extends Literal {
    protected static final String QNAME_PATTERN = PREFIXED_NAME_PATTERN + "|" + NCNAME_PATTERN;
    
    public QName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_QNAME);
    }
    
    public static boolean isQName(String expression) {
        return expression.matches(QNAME_PATTERN);
    }
}
