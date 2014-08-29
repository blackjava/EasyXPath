package xml;

import i18n.ErrorCode;
import org.junit.Test;
import static org.junit.Assert.*;

public class XPathTest {
    
    @Test
    public void parsing_a_null_value_generates_error() {
        InvalidExpressionException exception = null;
        
        try {
            XPath.parse(null);
        } catch (InvalidExpressionException iee) {
            exception = iee;
        }
        
        assertNotNull(exception);
        assertEquals(ErrorCode.EMPTY_EXPRESSION, exception.getErrorCode());
    }
    
    @Test
    public void parsing_an_empty_value_generates_error() {
        InvalidExpressionException exception = null;
        
        try {
            XPath.parse("");
        } catch (InvalidExpressionException iee) {
            exception = iee;
        }
        
        assertNotNull(exception);
        assertEquals(ErrorCode.EMPTY_EXPRESSION, exception.getErrorCode());
    }
    
    @Test
    public void parsing_a_valid_expression_generates_xpath() throws Exception {
        XPath xpath = XPath.parse(".");
        
        assertNotNull(xpath);
        assertEquals(1, xpath.length());
    }
}
