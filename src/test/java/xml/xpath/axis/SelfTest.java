package xml.xpath.axis;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;
import xml.XmlUtilities;
import xml.xpath.Axis;

public class SelfTest {

    @Test
    public void self_axis_is_registered_as_axis() throws Exception {
        Axis axis = Axis.get("self");
        assertEquals(Self.class, axis.getClass());
    }
    
    @Test
    public void self_node_returns_provided_node() {
        Node node = XmlUtilities.createElement("element");

        Axis axis = new Self(); 
        List<Node> result = axis.apply(node);
        
        assertEquals(1, result.size());
        assertEquals(node, result.get(0));
    }
    
}
