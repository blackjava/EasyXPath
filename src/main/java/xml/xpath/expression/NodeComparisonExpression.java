package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * Node comparisons are used to compare two nodes, by their identity or by their 
 * document order. The result of a node comparison is defined by the following 
 * rules:
 * 
 * The operands of a node comparison are evaluated in implementation-dependent 
 * order.
 * 
 * If either operand is an empty sequence, the result of the comparison is an 
 * empty sequence, and the implementation need not evaluate the other operand or 
 * apply the operator. However, an implementation may choose to evaluate the 
 * other operand in order to determine whether it raises an error.
 * 
 * Each operand must be either a single node or an empty sequence; otherwise a 
 * type error is raised [err:XPTY0004].
 * 
 * A comparison with the is operator is true if the two operand nodes have the 
 * same identity, and are thus the same node; otherwise it is false. See 
 * [XQuery and XPath Data Model (XDM) 3.0] for a definition of node identity.
 * 
 * A comparison with the << operator returns true if the left operand node 
 * precedes the right operand node in document order; otherwise it returns 
 * false.
 * 
 * A comparison with the >> operator returns true if the left operand node 
 * follows the right operand node in document order; otherwise it returns false.
 */
public class NodeComparisonExpression implements Expression {
    private static final String NODECOMPARISONEXPRESSION_PATTERN = "(is|\\<\\<|\\>\\>)";
    
    public NodeComparisonExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_NODECOMPARISON);
    }

    public static boolean isNodeComparisonExpression(String expression) {
        return expression.matches(NODECOMPARISONEXPRESSION_PATTERN);
    }
}
