package xml.xpath.expression;

import static xml.xpath.expression.NCName.NCNAME_PATTERN;
import static xml.xpath.expression.PrefixedName.PREFIXED_NAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * QName is a qualified name. A qualified name is an XML name optionally 
 * prefixed with a namespace.
 */
public class QName implements Expression {
    private static final String QNAME_PATTERN = PREFIXED_NAME_PATTERN + "|" + NCNAME_PATTERN;
    
    public QName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_QNAME);
    }
    
    public static boolean isQName(String expression) {
        return expression.matches(QNAME_PATTERN);
    }
}
