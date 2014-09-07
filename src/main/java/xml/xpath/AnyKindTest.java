package xml.xpath;

import org.w3c.dom.Node;

/**
 *
 */
public class AnyKindTest extends KindTest {
    public AnyKindTest() {}
    
    @Override
    public boolean test(Node node) {
        return (node != null);
    }
    
    @Override
    public String toString() {
        return "node()";
    }
}
