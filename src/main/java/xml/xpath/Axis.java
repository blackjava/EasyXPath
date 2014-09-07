package xml.xpath;

import java.util.List;
import org.w3c.dom.Node;

/**
 *
 */
public interface Axis {
    List<Node> apply(Node node);
}
