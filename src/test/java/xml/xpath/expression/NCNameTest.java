package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class NCNameTest {
    @Test
    public void valid_name_is_recognized() {
        assertTrue(NCName.isNCName("name"));
    }
    
    @Test
    public void name_starting_with_digit_is_not_recognized() {
        assertFalse(NCName.isNCName("123name"));
    }
    
    @Test
    public void name_containing_colon_is_not_recognized() {
        assertFalse(NCName.isNCName("namespace:name"));
    }

    @Test
    public void name_containing_space_is_not_recognized() {
        assertFalse(NCName.isNCName("namespace name"));
    }

    @Test
    public void name_containing_comma_is_not_recognized() {
        assertFalse(NCName.isNCName("namespace,name"));
    }
}
