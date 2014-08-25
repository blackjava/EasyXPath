package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.UnsupportedExpressionException;

/**
 *  An axis step returns a sequence of nodes that are reachable from the context 
 * node via a specified axis. Such a step has two parts: an axis, which defines 
 * the "direction of movement" for the step, and a node test, which selects 
 * nodes based on their kind, name, and/or type annotation.] If the context item 
 * is a node, an axis step returns a sequence of zero or more nodes; otherwise, 
 * a type error is raised [err:XPTY0020]. 
 * 
 * The resulting node sequence is returned in document order. A reverse step 
 * always points to a node that is further back in the document order, and may 
 * be followed by zero or more predicates.
 * 
 * In the abbreviated syntax for a step, the axis can be omitted and other 
 * shorthand notations can be used.
 * 
 * The unabbreviated syntax for an axis step consists of the axis name and node 
 * test separated by a double colon. The result of the step consists of the 
 * nodes reachable from the context node via the specified axis that have the 
 * node kind, name, and/or type annotation specified by the node test. For 
 * example, the step child::para selects the para element children of the 
 * context node: child is the name of the axis, and para is the name of the 
 * element nodes to be selected on this axis. 
 */
public class ReverseStep {
    private static final String REVERSE_AXIS_PATTERN = "(parent::|ancestor::|preceding-sibling::|preceding::|ancestor-or-self::)";
    private static final String ABBREVIATED_REVERSE_STEP_PATTERN = "\\.\\.";
    protected static final String REVERSE_STEP_PATTERN = "(" + REVERSE_AXIS_PATTERN + EQName.EQNAME_PATTERN + "|" + ABBREVIATED_REVERSE_STEP_PATTERN + ")";
    
    public ReverseStep() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_REVERSESTEP);
    }
    
    public static boolean isReverseStep(String expression) {
        return expression.matches(REVERSE_STEP_PATTERN);
    }
}
