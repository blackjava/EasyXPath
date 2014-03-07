package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class QNameTest {
    @Test
    public void name_without_namespace_is_recognized() {
        assertTrue(QName.isQName("name"));
    }
    
    @Test
    public void name_with_namespace_is_recognized() {
        assertTrue(QName.isQName("namespace:name"));
    }

    @Test
    public void name_with_empty_namespace_is_not_recognized() {
        assertFalse(QName.isQName(":name"));
    }

    @Test
    public void namespace_with_empty_name_is_not_recognized() {
        assertFalse(QName.isQName("namespace:"));
    }
}
