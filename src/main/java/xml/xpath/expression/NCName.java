package xml.xpath.expression;

import static xml.xpath.expression.Name.NAME_PATTERN;

import i18n.ErrorCode;

/**
 * NCName is a non-colonized XML name. NCName is used when a name should not be 
 * qualified by a namespace.
 */
public class NCName extends Literal {
    protected static final String NCNAME_PATTERN = "(?=" + NAME_PATTERN + ")[^:]+";
    
    public NCName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_NCNAME);
    }
    
    public static boolean isNCName(String expression) {
        return expression.matches(NCNAME_PATTERN);
    }
}
