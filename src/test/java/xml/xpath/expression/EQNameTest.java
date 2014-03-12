package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class EQNameTest {
    @Test
    public void name_without_prefix_is_recognized() {
        assertTrue(EQName.isEqName("name"));
    }

    @Test
    public void name_with_namespace_is_recognized() {
        assertTrue(EQName.isEqName("namespace:name"));
    }

    @Test
    public void name_with_two_namespaces_is_not_recognized() {
        assertFalse(EQName.isEqName("namespace:namespace:name"));
    }
    
    @Test
    public void name_with_braced_uri_identifier_is_recognized() {
        assertTrue(EQName.isEqName("Q{http://test.com}name"));
    }

    @Test
    public void name_with_braced_uri_identifier_and_namespace_is_not_recognized() {
        assertFalse(EQName.isEqName("Q{http://test.com}namespace:name"));
    }

    @Test
    public void two_names_without_prefix_is_not_recognized() {
        assertFalse(EQName.isEqName("name name"));
    }
}
