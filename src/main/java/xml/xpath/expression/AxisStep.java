package xml.xpath.expression;

import static xml.xpath.expression.ForwardStep.FORWARD_STEP_PATTERN;
import static xml.xpath.expression.ReverseStep.REVERSE_STEP_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * An axis step returns a sequence of nodes that are reachable from the context 
 * node via a specified axis. Such a step has two parts: an axis, which defines 
 * the "direction of movement" for the step, and a node test, which selects 
 * nodes based on their kind, name, and/or type annotation.  
 * 
 * If the context item is a node, an axis step returns a sequence of zero or 
 * more nodes; otherwise, a type error is raised [err:XPTY0020]. The resulting 
 * node sequence is returned in document order. An axis step may be either a 
 * forward step or a reverse step, followed by zero or more predicates.
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
public class AxisStep implements Expression {
    private static final String AXIS_STEP_PATTERN = "(" + FORWARD_STEP_PATTERN + "|" + REVERSE_STEP_PATTERN + ")";
    
    public AxisStep() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_AXISSTEP);
    }
    
    public static boolean isAxisStep(String expression) {
        return expression.matches(AXIS_STEP_PATTERN);
    }
}
