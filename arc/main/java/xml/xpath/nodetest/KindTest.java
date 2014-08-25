package xml.xpath.nodetest;

import static xml.xpath.nodetest.DocumentTest.DOCUMENTTEST_PATTERN;
import static xml.xpath.nodetest.ElementTest.ELEMENTTEST_PATTERN;
import static xml.xpath.nodetest.AttributeTest.ATTRIBUTETEST_PATTERN;
import static xml.xpath.nodetest.SchemaElementTest.SCHEMAELEMENTTEST_PATTERN;
import static xml.xpath.nodetest.SchemaAttributeTest.SCHEMAATTRIBUTETEST_PATTERN;
import static xml.xpath.nodetest.PITest.PITEST_PATTERN;
import static xml.xpath.nodetest.CommentTest.COMMENTTEST_PATTERN;
import static xml.xpath.nodetest.TextTest.TEXTTEST_PATTERN;
import static xml.xpath.nodetest.NamespaceNodeTest.NAMESPACENODETEST_PATTERN;
import static xml.xpath.nodetest.AnyKindTest.ANYKINDTEST_PATTERN;

import xml.xpath.NodeTest;

/**
 *  An alternative form of a node test called a kind test can select nodes based 
 * on their kind, name, and type annotation.
 * 
 * When a kind test is used in a node test, only those nodes on the designated 
 * axis that match the kind test are selected. Shown below are several examples 
 * of kind tests that might be used in path expressions:
 * 
 * - node() matches any node.
 * - text() matches any text node.
 * - comment() matches any comment node.
 * - namespace-node() matches any namespace node.
 * - element() matches any element node.
 * - schema-element(person) matches any element node whose name is person (or 
 *   is in the substitution group headed by person), and whose type annotation 
 *   is the same as (or is derived from) the declared type of the person element 
 *   in the in-scope element declarations.
 * - element(person) matches any element node whose name is person, regardless 
 *   of its type annotation.
 * - element(person, surgeon) matches any non-nilled element node whose name is 
 *   person, and whose type annotation is surgeon or is derived from surgeon.
 * - element(*, surgeon) matches any non-nilled element node whose type 
 *   annotation is surgeon (or is derived from surgeon), regardless of its name.
 * - attribute() matches any attribute node.
 * - attribute(price) matches any attribute whose name is price, regardless of 
 *   its type annotation.
 * - attribute(*, xs:decimal) matches any attribute whose type annotation is 
 *   xs:decimal (or is derived from xs:decimal), regardless of its name.
 * - document-node() matches any document node.
 * - document-node(element(book)) matches any document node whose content 
 *   consists of a single element node that satisfies the kind test 
 *   element(book), interleaved with zero or more comments and processing 
 *   instructions.
 */
public class KindTest implements NodeTest {
    public static final String KINDTEST_PATTERN = "(" + DOCUMENTTEST_PATTERN 
            + "|" + ELEMENTTEST_PATTERN + "|" + ATTRIBUTETEST_PATTERN + "|"  
            + SCHEMAELEMENTTEST_PATTERN + "|" + SCHEMAATTRIBUTETEST_PATTERN 
            + "|" + PITEST_PATTERN + "|" + COMMENTTEST_PATTERN + "|" 
            + TEXTTEST_PATTERN + "|" + NAMESPACENODETEST_PATTERN + "|" 
            + ANYKINDTEST_PATTERN + ")";
    
    public static boolean isKindTest(String expression) {
        return expression.matches(KINDTEST_PATTERN);
    }
}
