package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class URIQualifiedNameTest {
    @Test
    public void valid_uriqualified_name_is_recognized() {
        assertTrue(URIQualifiedName.isUriQualifiedName("Q{http://test.com}name"));
    }
    
    @Test
    public void braced_uri_without_element_name_is_not_recognized() {
        assertFalse(URIQualifiedName.isUriQualifiedName("Q{http://test.com}"));
    }

    @Test
    public void faulty_braced_uri_is_not_recognized() {
        assertFalse(URIQualifiedName.isUriQualifiedName("Q{http://test{.com}name"));
    }
}
