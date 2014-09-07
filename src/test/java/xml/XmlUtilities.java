package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 */
public final class XmlUtilities {

    public static Attr createAttribute(String name) {
        Attr attribute = null;
        
        try {
            Document document = createDocument();
            attribute = document.createAttribute(name);
        } catch (ParserConfigurationException pce) {
            // Ignore parser configuration exceptions
        }
        
        return attribute;
    }
    
    public static Element createElement(String name) {
        Element element = null;
        
        try {
            Document document = createDocument();
            element = document.createElement(name);
        } catch (ParserConfigurationException pce) {
            // Ignore parser configuration exceptions
        }
        
        return element;
    }

    private static Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        return document;
    }
}
