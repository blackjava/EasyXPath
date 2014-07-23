package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A quantified expression that evaluates to true or false depending on whether 
 * or not items in an expression satisfy a condition. The expression may have 
 * two quantifiers; the quantifier some will evaluate to true if one or more 
 * items satisfy the condition, the quantifier every will evaluate to true only 
 * if all items satisfy the condition
 */
public class QuantifiedExpression implements Expression {
    protected static final String QUANTIFIED_EXPRESSION_PATTERN = "(some|every) \\$.+ in .+ satisfies .+";
    
    public QuantifiedExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_QUANTIFIED);
    }
    
    /**
     * Determines if the specified string is a quantified expression.
     */
    public static boolean isQuantifiedExpression(String expression) {
        return expression.matches(QUANTIFIED_EXPRESSION_PATTERN);
    }
}
