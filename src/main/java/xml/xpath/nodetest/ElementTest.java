package xml.xpath.nodetest;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * An ElementTest is used to match an element node by its name and/or type 
 * annotation.
 * 
 * The ElementName and TypeName of an ElementTest have their prefixes expanded 
 * to namespace URIs by means of the statically known namespaces, or if 
 * unprefixed, the default element/type namespace. The ElementName need not be 
 * present in the in-scope element declarations, but the TypeName must be 
 * present in the in-scope schema types [err:XPST0008]. Note that substitution 
 * groups do not affect the semantics of ElementTest.
 * 
 * An ElementTest may take any of the following forms:
 * 
 * - element() and element(*) match any single element node, regardless of its 
 *   name or type annotation.
 * - element( ElementName ) matches any element node whose name is ElementName, 
 *   regardless of its type annotation or nilled property.
 *   Example: element(person) matches any element node whose name is person.
 * - element( ElementName , TypeName ) matches an element node whose name is 
 *   ElementName if derives-from( AT, TypeName ) is true, where AT is the type 
 *   annotation of the element node, and the nilled property of the node is 
 *   false.
 *   Example: element(person, surgeon) matches a non-nilled element node whose 
 *   name is person and whose type annotation is surgeon (or is derived from 
 *   surgeon).
 * - element( ElementName, TypeName ?) matches an element node whose name is 
 *   ElementName if derives-from( AT, TypeName ) is true, where AT is the type 
 *   annotation of the element node. The nilled property of the node may be 
 *   either true or false.
 *   Example: element(person, surgeon?) matches a nilled or non-nilled element 
 *   node whose name is person and whose type annotation is surgeon (or is 
 *   derived from surgeon).
 * - element(*, TypeName ) matches an element node regardless of its name, if 
 *   derives-from( AT, TypeName ) is true, where AT is the type annotation of 
 *   the element node, and the nilled property of the node is false.
 *   Example: element(*, surgeon) matches any non-nilled element node whose 
 *   type annotation is surgeon (or is derived from surgeon), regardless of its 
 *   name.
 * - element(*, TypeName ?) matches an element node regardless of its name, if 
 *   derives-from( AT, TypeName ) is true, where AT is the type annotation of 
 *   the element node. The nilled property of the node may be either true or 
 *   false.
 *   Example: element(*, surgeon?) matches any nilled or non-nilled element node 
 *   whose type annotation is surgeon (or is derived from surgeon), regardless 
 *   of its name.
 */
public class ElementTest implements NodeTest {
    private static final String ELEMENTTEST_PATTERN = "element\\(((" + EQNAME_PATTERN + "|\\*)(\\," + EQNAME_PATTERN + "(\\?)?)?)?\\)";
    
    public ElementTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_ELEMENTTEST);
    }
    
    public static boolean isElementTest(String expression) {
        return expression.matches(ELEMENTTEST_PATTERN);
    }
}
