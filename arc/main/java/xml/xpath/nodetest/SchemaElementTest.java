package xml.xpath.nodetest;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * A SchemaElementTest matches an element node against a corresponding element 
 * declaration found in the in-scope element declarations.
 * 
 * The ElementName of a SchemaElementTest has its prefixes expanded to a 
 * namespace URI by means of the statically known namespaces, or if unprefixed, 
 * the default element/type namespace. If the ElementName specified in the 
 * SchemaElementTest is not found in the in-scope element declarations, a static 
 * error is raised [err:XPST0008].
 * 
 * A SchemaElementTest matches a candidate element node if all of the following 
 * conditions are satisfied:
 * 
 * Either:
 * - The name N of the candidate node matches the specified ElementName, or
 * - The name N of the candidate node matches the name of an element declaration 
 * that is a member of the actual substitution group headed by the declaration 
 * of element ElementName.
 * 
 * Note:
 * The term "actual substitution group" is defined in [XML Schema 1.1]. The 
 * actual substitution group of an element declaration H includes those element 
 * declarations P that are declared to have H as their direct or indirect 
 * substitution group head, provided that P is not declared as abstract, and 
 * that P is validly substitutable for H, which means that there must be no 
 * blocking constraints that prevent substitution.
 * 
 * The schema element declaration named N is not abstract.
 * 
 * derives-from( AT, ET ) is true, where AT is the type annotation of the 
 * candidate node and ET is the schema type declared in the schema element 
 * declaration named N.
 * 
 * If the schema element declaration named N is not nillable, then the nilled 
 * property of the candidate node is false.
 * 
 * Example: The SchemaElementTest schema-element(customer) matches a candidate 
 * element node in the following two situations:
 * 
 * customer is a top-level element declaration in the in-scope element 
 * declarations; the name of the candidate node is customer; the element 
 * declaration of customer is not abstract; the type annotation of the candidate 
 * node is the same as or derived from the schema type declared in the customer 
 * element declaration; and either the candidate node is not nilled, or customer 
 * is declared to be nillable.
 * 
 * customer is a top-level element declaration in the in-scope element 
 * declarations; the name of the candidate node is client; client is an actual 
 * (non-abstract and non-blocked) member of the substitution group of customer; 
 * the type annotation of the candidate node is the same as or derived from the 
 * schema type declared for the client element; and either the candidate node is 
 * not nilled, or client is declared to be nillable.
 */
public class SchemaElementTest implements NodeTest {
    protected static final String SCHEMAELEMENTTEST_PATTERN = "schema-element\\(" + EQNAME_PATTERN + "\\)";
    
    public SchemaElementTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_SCHEMAELEMENTTEST);
    }
    
    public static boolean isSchemaElementTest(String expression) {
        return expression.matches(SCHEMAELEMENTTEST_PATTERN);
    }
}
