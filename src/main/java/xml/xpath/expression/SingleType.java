package xml.xpath.expression;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

public class SingleType implements Expression {
    protected static final String SINGLETYPE_PATTERN = EQNAME_PATTERN + "(\\?)?";
    
    public SingleType() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_SINGLETYPE);
    }
    
    public static boolean isSingleType(String expression) {
        return expression.matches(SINGLETYPE_PATTERN);
    }
}
