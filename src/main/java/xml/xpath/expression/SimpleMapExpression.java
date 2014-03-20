package xml.xpath.expression;


import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;
import xml.xpath.Expression;
import static xml.xpath.expression.PathExpression.PATH_EXPRESSION_PATTERN;

/**
 * The simple map operator "!" is used for simple mappings. Both its left-hand 
 * side expression and its right-hand-side expression may return a mixed 
 * sequence of nodes and non-nodes.
 * 
 * Each operation E1!E2 is evaluated as follows: 
 * Expression E1 is evaluated to a sequence S. 
 * Each item in S then serves in turn to provide an inner focus (the item as the 
 * context item, its position in S as the context position, the length of S as 
 * the context size) for an evaluation of E2 in the dynamic context. 
 * The sequences resulting from all the evaluations of E2 are combined as 
 * follows: Every evaluation of E2 returns a (possibly empty) sequence of items. 
 * These sequences are concatenated and returned. 
 * 
 * If ordering mode is ordered, the returned sequence preserves the orderings 
 * within and among the subsequences generated by the evaluations of E2; 
 * otherwise the order of the returned sequence is implementation-dependent.
 */
public class SimpleMapExpression implements Expression {
    protected static final String SIMPLE_MAP_EXPRESSION_PATTERN = PATH_EXPRESSION_PATTERN + "( ! " + PATH_EXPRESSION_PATTERN + ")*";
    
    public SimpleMapExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_SIMPLEMAP);
    }
    
    public static boolean isSimpleMapExpression(String expression) {
        return expression.matches(SIMPLE_MAP_EXPRESSION_PATTERN);
    }
}
