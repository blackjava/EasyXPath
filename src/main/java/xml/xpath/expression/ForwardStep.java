package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 *  An axis step returns a sequence of nodes that are reachable from the context 
 * node via a specified axis. Such a step has two parts: an axis, which defines 
 * the "direction of movement" for the step, and a node test, which selects 
 * nodes based on their kind, name, and/or type annotation.] If the context item 
 * is a node, an axis step returns a sequence of zero or more nodes; otherwise, 
 * a type error is raised [err:XPTY0020]. 
 * 
 * The resulting node sequence is returned in document order. A forward step 
 * always points to a node that is further ahead in the document order, and may 
 * be followed by zero or more predicates.
 */
public class ForwardStep {
    private static final String FORWARD_AXIS_PATTERN = "(child::|descendant::|attribute::|self::|descendant-or-self::|following-sibling::|following::|namespace::)";
    private static final String ABBREVIATED_FORWARD_STEP_PATTERN = "@?";
    private static final String FORWARD_STEP_PATTERN = "(" + FORWARD_AXIS_PATTERN + "|" + ABBREVIATED_FORWARD_STEP_PATTERN + ")" + EQName.EQNAME_PATTERN;
    
    public ForwardStep() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_FORWARDSTEP);
    }
    
    public static boolean isForwardStep(String expression) {
        return expression.matches(FORWARD_STEP_PATTERN);
    }
}
