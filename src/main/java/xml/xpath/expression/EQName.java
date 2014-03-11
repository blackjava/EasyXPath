package xml.xpath.expression;

import static xml.xpath.expression.QName.QNAME_PATTERN;
import static xml.xpath.expression.URIQualifiedName.URIQUALIFIEDNAME_PATTERN;

import i18n.ErrorCode;

/**
 * An expanded QName consists of an optional namespace URI and a local name. 
 * An expanded QName also retains its original namespace prefix (if any), to 
 * facilitate casting the expanded QName into a string. Two expanded QNames are 
 * equal is their namespace URIs are equal and their local names are equal, even 
 * if their namespace prefixes are not equal.
 */
public class EQName extends Literal {
    protected static final String EQNAME_PATTERN = "(" + QNAME_PATTERN + "|" + URIQUALIFIEDNAME_PATTERN + ")";
    
    public EQName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_EQNAME);
    }
    
    public static boolean isEqName(String expression) {
        return expression.matches(EQNAME_PATTERN);
    }
}
