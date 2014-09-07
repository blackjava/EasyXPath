package xml.xpath;

import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Element;
import xml.XmlUtilities;

/**
 *
 */
public class AnyKindTestTest {
    
    @Test
    public void to_string_returns_any_node_test() {
        AnyKindTest kindTest = new AnyKindTest();
        assertEquals("node()", kindTest.toString());
    }
    
    @Test
    public void element_is_a_match() {
        Element element = XmlUtilities.createElement("element");

        AnyKindTest kindTest = new AnyKindTest();
        assertTrue(kindTest.test(element));
    }
    
    @Test
    public void attribute_is_a_match() {
        Element element = XmlUtilities.createElement("element");

        AnyKindTest kindTest = new AnyKindTest();
        assertTrue(kindTest.test(element));
    }

    @Test
    public void null_is_not_a_match() {
        AnyKindTest kindTest = new AnyKindTest();
        assertFalse(kindTest.test(null));
    }
}
