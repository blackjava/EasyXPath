package xml.xpath;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xml.XmlUtilities;
import xml.xpath.axis.Self;

public class AxisStepTest {
    
    @Test
    public void current_node_abbreviation_recognized() {
        AxisStep axisStep = AxisStep.parse(".");
        
        assertEquals(Self.class, axisStep.getAxis().getClass());
        assertEquals(AnyKindTest.class, axisStep.getNodeTest().getClass());
    }

    @Test
    public void self_node_returns_provided_nodes_in_preserved_order() {
        Node nodeOne = XmlUtilities.createElement("element-one");
        Node nodeTwo = XmlUtilities.createElement("element-two");
        List<Node> nodes = Arrays.asList(nodeOne, nodeTwo);
        
        AxisStep axisStep = AxisStep.parse("self::node()");
        List<Node> result = axisStep.apply(nodes);
        
        assertEquals(2, result.size());
        assertEquals(nodeOne, result.get(0));
        assertEquals(nodeTwo, result.get(1));
    }
    
}
