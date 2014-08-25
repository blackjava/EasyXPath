package xml.xpath.literal;

import xml.xpath.literal.BracedUriLiteral;
import org.junit.Test;
import static org.junit.Assert.*;

public class BracedUriLiteralTest {
    @Test
    public void empty_uri_literal_is_recognized() {
        assertTrue(BracedUriLiteral.isBracedUriLiteral("Q{}"));
    }
    
    @Test
    public void uri_literal_is_recognized() {
        assertTrue(BracedUriLiteral.isBracedUriLiteral("Q{http://www.w3.org/TR/xpath-30/#prod-xpath30-URIQualifiedName}"));
    }

    @Test
    public void uri_literal__containing_braces_is_not_recognized() {
        assertFalse(BracedUriLiteral.isBracedUriLiteral("Q{http://www.test{ing.com}"));
    }

    @Test
    public void uri_without_braces_is_not_recognized() {
        assertFalse(BracedUriLiteral.isBracedUriLiteral("http://www.testing.com"));
    }
}
