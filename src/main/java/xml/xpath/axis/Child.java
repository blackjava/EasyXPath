package xml.xpath.axis;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.xpath.Axis;

/**
 *
 */
public class Child implements Axis {

    @Override
    public List<Node> apply(Node node) {
        List<Node> result = new ArrayList<>();
        
        NodeList childNodes = node.getChildNodes();
        for (int index = 0; index < childNodes.getLength(); index++) {
            result.add(childNodes.item(index));
        }
        
        return result;
    }
    
}
