package xml.xpath.nodetest;

import org.junit.Test;
import static org.junit.Assert.*;

public class DocumentTestTest {
    @Test
    public void empty_document_test_is_recognized() {
        assertTrue(DocumentTest.isDocumentTest("document-node()"));
    }

    @Test
    public void document_test_with_element_test_is_recognized() {
        assertTrue(DocumentTest.isDocumentTest("document-node(element())"));
    }

    @Test
    public void document_test_with_schema_element_test_is_recognized() {
        assertTrue(DocumentTest.isDocumentTest("document-node(schema-element(node))"));
    }
    
    @Test
    public void document_test_with_wildcard_parameter_is_not_recognized() {
        assertFalse(DocumentTest.isDocumentTest("document-node(*)"));
    }

    @Test
    public void document_test_with_function_parameter_is_not_recognized() {
        assertFalse(DocumentTest.isDocumentTest("document-node(function())"));
    }

    @Test
    public void document_test_with_string_parameter_is_not_recognized() {
        assertFalse(DocumentTest.isDocumentTest("document-node(\"element()\")"));
        assertFalse(DocumentTest.isDocumentTest("document-node('element()')"));
    }
}