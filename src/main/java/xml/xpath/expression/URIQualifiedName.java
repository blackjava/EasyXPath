package xml.xpath.expression;

import static xml.xpath.expression.BracedUriLiteral.BRACEDURI_LITERAL_PATTERN;
import static xml.xpath.expression.NCName.NCNAME_PATTERN;

import i18n.ErrorCode;

/**
 * A URI qualified name defines the namespace as a literal instead of a lexical 
 * value.
 */
public class URIQualifiedName extends Literal {
    protected static final String URIQUALIFIEDNAME_PATTERN = BRACEDURI_LITERAL_PATTERN + NCNAME_PATTERN;
    
    public URIQualifiedName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_URIQUALIFIEDNAME);
    }
    
    public static boolean isUriQualifiedName(String expression) {
        return expression.matches(URIQUALIFIEDNAME_PATTERN);
    }
}
