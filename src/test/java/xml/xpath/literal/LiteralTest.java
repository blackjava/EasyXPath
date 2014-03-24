package xml.xpath.literal;

import xml.xpath.literal.Literal;
import org.junit.Test;
import static org.junit.Assert.*;

public class LiteralTest {
    
    @Test
    public void number_is_recognized() {
        assertTrue(Literal.isLiteral(" 123.4\t\r\n"));
    }
    
    @Test
    public void string_is_recognized() {
        assertTrue(Literal.isLiteral(" \"text 123\"\t\r\n"));
        assertTrue(Literal.isLiteral(" 'text 123'\t\r\n"));
    }
    
    @Test
    public void random_unquoted_characters_is_not_recognized() {
        assertFalse(Literal.isLiteral("characters123"));
    }
}
