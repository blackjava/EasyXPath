package xml.xpath.expression;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A variable reference is an EQName preceeded by a $-sign. 
 * An unprefixed variable reference is in no namespace. Two variable references 
 * are equivalent if their expanded QNames are equal, as defined by the eq 
 * operator. The scope of a variable binding is defined separately for each kind 
 * of expression that can bind variables.
 */
public class VarRef implements Expression {
    protected static final String VARREF_PATTERN = "\\$" + EQNAME_PATTERN;
    
    public VarRef() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_VARREF);
    }
    
    public static boolean isVarRef(String expression) {
        return expression.matches(VARREF_PATTERN);
    }
}
