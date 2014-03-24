package xml.xpath.literal;

import xml.xpath.literal.StringLiteral;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringLiteralTest {
    
    @Test
    public void quoted_string_is_recognized() {
        assertTrue(StringLiteral.isStringLiteral("\"string 123\""));
        assertTrue(StringLiteral.isStringLiteral("'string 123'"));
    }
    
    @Test
    public void string_with_unterminated_quote_is_not_recognized() {
        assertFalse(StringLiteral.isStringLiteral("\"string 123"));
        assertFalse(StringLiteral.isStringLiteral("'string 123"));
    }

    @Test
    public void string_with_characters_outside_quotes_is_not_recognized() {
        assertFalse(StringLiteral.isStringLiteral("\"string 123\" bad"));
        assertFalse(StringLiteral.isStringLiteral("'string 123' bad"));
    }

    @Test
    public void string_with_whitespace_outside_quotes_is_recognized() {
        assertTrue(StringLiteral.isStringLiteral(" \"string 123\"\t\r\n"));
        assertTrue(StringLiteral.isStringLiteral(" 'string 123'\t\r\n"));
    }
    
    @Test
    public void string_containing_unescaped_quote_is_not_recognized() {
        assertFalse(StringLiteral.isStringLiteral("\"str\"ing\" 123"));
        assertFalse(StringLiteral.isStringLiteral("'str'ing' 123"));
    }
    
    @Test
    public void string_containing_escaped_quote_is_recognized() {
        assertTrue(StringLiteral.isStringLiteral("\"str\\\"ing 123\""));
        assertTrue(StringLiteral.isStringLiteral("\"str\"\"ing 123\""));
        assertTrue(StringLiteral.isStringLiteral("'str\\'ing 123'"));
        assertTrue(StringLiteral.isStringLiteral("'str''ing 123'"));
    }
}
