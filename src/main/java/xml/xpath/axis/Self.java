package xml.xpath.axis;

import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Node;
import xml.xpath.Axis;

/**
 *
 */
public class Self implements Axis {

    @Override
    public List<Node> apply(Node node) {
        return Arrays.asList(node);
    }
}
