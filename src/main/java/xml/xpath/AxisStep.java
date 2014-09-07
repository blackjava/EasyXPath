package xml.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import xml.xpath.axis.Self;

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
public class AxisStep extends Step {
    private final Axis axis;
    private final NodeTest nodeTest;
    
    private AxisStep(Axis axis, NodeTest nodeTest) {
        this.axis = axis;
        this.nodeTest = nodeTest;
    }

    public List<Node> apply(List<Node> nodes) {
        List<Node> matchingNodes = new ArrayList<>();
        
        for (Node node : nodes) {
            List<Node> axisNodes = axis.apply(node);
            
            for (Node axisNode : axisNodes) {
                if (nodeTest.test(axisNode)) {
                    matchingNodes.add(axisNode);
                }
            }
        }
        
        return matchingNodes;
    }
    
    public Axis getAxis() {
        return axis;
    }
    
    public NodeTest getNodeTest() {
        return nodeTest;
    }
    
    public static AxisStep parse(String expression) {
        Axis axis = null;
        NodeTest nodeTest = null;
        
        if (expression.equals(".")) {
            expression = "self::node()";
        }
        
        int separatorIndex = expression.indexOf("::");
        if (separatorIndex >= 0) {
            String axisName = expression.substring(0, separatorIndex);
            
            if ("self".equalsIgnoreCase(axisName)) {
                axis = new Self();
            }
            
            String nodeTestName = expression.substring(separatorIndex + 2);
            
            if ("node()".equalsIgnoreCase(nodeTestName)) {
                nodeTest = new AnyKindTest();
            }
        }

        return new AxisStep(axis, nodeTest);
    }
    
}
