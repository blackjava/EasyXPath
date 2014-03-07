package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class NameTest {

    @Test
    public void name_without_namespace_is_recognized() {
        assertTrue(Name.isName("name123"));
    }
    
    @Test
    public void name_with_empty_namespace_is_recognized() {
        assertTrue(Name.isName(":name123"));
    }

    @Test
    public void name_with_namespace_is_recognized() {
        assertTrue(Name.isName("namespace123:name123"));
    }

    @Test
    public void name_with_dash_and_underscore_is_recognized() {
        assertTrue(Name.isName("node-namespace123:node_name123"));
    }
    
    @Test
    public void name_starting_with_digit_is_not_recognized() {
        assertFalse(Name.isName("123name"));
    }
    
}
