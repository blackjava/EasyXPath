package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrefixedNameTest {
    @Test
    public void name_with_namespace_is_recognized() {
        assertTrue(PrefixedName.isPrefixedName("namespace:name"));
    }

    @Test
    public void name_without_namespace_is_not_recognized() {
        assertFalse(PrefixedName.isPrefixedName("name"));
    }
    
    @Test
    public void name_with_empty_namespace_is_not_recognized() {
        assertFalse(PrefixedName.isPrefixedName(":name"));
    }

    @Test
    public void namespace_with_empty_name_is_not_recognized() {
        assertFalse(PrefixedName.isPrefixedName("namespace:"));
    }

    @Test
    public void name_with_multiple_namespaces_is_not_recognized() {
        assertFalse(PrefixedName.isPrefixedName("namespace:namespace:name"));
    }
}
