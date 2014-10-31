package xml.xpath.axis;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xml.XmlUtilities;
import xml.xpath.Axis;

/**
 *
 */
public class ChildTest {
    
    @Test
    public void child_axis_returns_all_children() {
        Document document = XmlUtilities.createDocument();
        Node firstChild = document.createElement("child-one");
        Node secondChild = document.createElement("child-two");
        
        Node root = document.createElement("root");
        root.appendChild(firstChild);
        root.appendChild(secondChild);

        Axis axis = new Child();
        List<Node> result = axis.apply(root);
        
        assertEquals(2, result.size());
        assertEquals(firstChild, result.get(0));
        assertEquals(secondChild, result.get(1));
    }
    
}
