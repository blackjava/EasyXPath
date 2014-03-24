package xml.xpath.nodetest;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * A SchemaAttributeTest matches an attribute node against a corresponding 
 * attribute declaration found in the in-scope attribute declarations.
 * 
 * The AttributeName of a SchemaAttributeTest has its prefixes expanded to a 
 * namespace URI by means of the statically known namespaces. If unprefixed, an 
 * AttributeName is in no namespace. If the AttributeName specified in the 
 * SchemaAttributeTest is not found in the in-scope attribute declarations, a 
 * static error is raised [err:XPST0008].
 * 
 * A SchemaAttributeTest matches a candidate attribute node if both of the 
 * following conditions are satisfied:
 * 
 * - The name of the candidate node matches the specified AttributeName.
 * - derives-from( AT, ET ) is true, where AT is the type annotation of the 
 *   candidate node and ET is the schema type declared for attribute 
 *   AttributeName in the in-scope attribute declarations.
 * 
 * Example: The SchemaAttributeTest schema-attribute(color) matches a candidate 
 * attribute node if color is a top-level attribute declaration in the in-scope 
 * attribute declarations, the name of the candidate node is color, and the type 
 * annotation of the candidate node is the same as or derived from the schema 
 * type declared for the color attribute.
 */
public class SchemaAttributeTest implements NodeTest {
    private static final String SCHEMAATTRIBUTETEST_PATTERN = "schema-attribute\\(" + EQNAME_PATTERN + "\\)";
    
    public SchemaAttributeTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_SCHEMAATTRIBUTETEST);
    }
    
    public static boolean isSchemaAttributeTest(String expression) {
        return expression.matches(SCHEMAATTRIBUTETEST_PATTERN);
    }
}
