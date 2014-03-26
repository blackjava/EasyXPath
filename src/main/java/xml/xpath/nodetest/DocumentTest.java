package xml.xpath.nodetest;

import static xml.xpath.nodetest.ElementTest.ELEMENTTEST_PATTERN;
import static xml.xpath.nodetest.SchemaElementTest.SCHEMAELEMENTTEST_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * A DocumentTest is used to match a document node by its element type.
 * 
 * document-node() matches any document node.
 * 
 * document-node( E ) matches any document node that contains exactly one 
 * element node, optionally accompanied by one or more comment and processing 
 * instruction nodes, if E is an ElementTest or SchemaElementTest that matches 
 * the element node (see 2.5.5.3 Element Test and 2.5.5.4 Schema Element Test).
 * 
 * Example: document-node(element(book)) matches a document node containing 
 * exactly one element node that is matched by the ElementTest element(book). 
 */
public class DocumentTest implements NodeTest {
    protected static final String DOCUMENTTEST_PATTERN = "document-node\\((" + ELEMENTTEST_PATTERN + "|" + SCHEMAELEMENTTEST_PATTERN + ")?\\)";
    
    public DocumentTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_DOCUMENTTEST);
    }
    
    public static boolean isDocumentTest(String expression) {
        return expression.matches(DOCUMENTTEST_PATTERN);
    }
}
