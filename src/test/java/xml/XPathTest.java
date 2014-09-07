package xml;

import i18n.ErrorCode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xml.xpath.axis.Self;

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

    @Test
    public void self_node_returns_proper_node() throws Exception {
        Element element = XmlUtilities.createElement("element");
        
        XPath xpath = XPath.parse("self::node()");
        xpath.apply(element);

    }
}
