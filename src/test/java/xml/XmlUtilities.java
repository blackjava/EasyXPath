package xml;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        Document document = createDocument();
        if (document != null) {
            attribute = document.createAttribute(name);
        }
        
        return attribute;
    }
    
    public static Element createElement(String name) {
        Element element = null;
        
        Document document = createDocument();
        if (document != null) {
            element = document.createElement(name);
        }
        
        return element;
    }

    public static Document createDocument() {
        Document document = null;
                
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
        } catch (ParserConfigurationException ex) {
            // Ignore parser configuration errors
        }
        
        return document;
    }
}
