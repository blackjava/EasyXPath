package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;

/**
 * NCName is a non-colonized XML name. NCName is used when a name should not be 
 * qualified by a namespace.
 */
public class NCName extends Literal {
    private static final String NCNAME_START_CHARACTER = "([A-Z]|\\_|[a-z]|[\\x{C0}-\\x{D6}]|[\\x{D8}-\\x{F6}]|[\\x{F8}-\\x{2FF}]|[\\x{370}-\\x{37D}]|[\\x{37F}-\\x{1FFF}]|[\\x{200C}-\\x{200D}]|[\\x{2070}-\\x{218F}]|[\\x{2C00}-\\x{2FEF}]|[\\x{3001}-\\x{D7FF}]|[\\x{F900}-\\x{FDCF}]|[\\x{FDF0}-\\x{FFFD}]|[\\x{10000}-\\x{EFFFF}])";
    private static final String NCNAME_CHARACTER = "(" + NCNAME_START_CHARACTER + "|\\-|\\.|[0-9]|\\x{B7}|[\\x{0300}-\\x{036F}|[\\x{203F}-\\x{2040}]])";
    protected static final String NCNAME_PATTERN = NCNAME_START_CHARACTER + NCNAME_CHARACTER + "*";
    
    public NCName() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_NCNAME);
    }
    
    public static boolean isNCName(String expression) {
        return expression.matches(NCNAME_PATTERN);
    }
}
