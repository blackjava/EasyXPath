package xml.xpath.nodetest;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * An AttributeTest is used to match an attribute node by its name and/or type 
 * annotation.
 * 
 * The AttributeName and TypeName of an AttributeTest have their prefixes 
 * expanded to namespace URIs by means of the statically known namespaces. If 
 * unprefixed, the AttributeName is in no namespace, but an unprefixed TypeName 
 * is in the default element/type namespace. The AttributeName need not be 
 * present in the in-scope attribute declarations, but the TypeName must be 
 * present in the in-scope schema types [err:XPST0008].
 * 
 * An AttributeTest may take any of the following forms:
 * 
 * attribute() and attribute(*) match any single attribute node, regardless of 
 * its name or type annotation.
 * 
 * attribute( AttributeName ) matches any attribute node whose name is 
 * AttributeName, regardless of its type annotation.
 * Example: attribute(price) matches any attribute node whose name is price.
 * 
 * - attribute( AttributeName, TypeName ) matches an attribute node whose name 
 * is AttributeName if derives-from( AT, TypeName ) is true, where AT is the 
 * type annotation of the attribute node.
 * Example: attribute(price, currency) matches an attribute node whose name is 
 * price and whose type annotation is currency (or is derived from currency).
 * 
 * attribute(*, TypeName ) matches an attribute node regardless of its name, 
 * if derives-from( AT, TypeName ) is true, where AT is the type annotation of 
 * the attribute node.
 * Example: attribute(*, currency) matches any attribute node whose type 
 * annotation is currency (or is derived from currency), regardless of its name.
 */
public class AttributeTest implements NodeTest {
    private static final String ATTRIBUTETEST_PATTERN = "attribute\\(((" + EQNAME_PATTERN + "|\\*)(," + EQNAME_PATTERN + ")?)?\\)";
    
    public AttributeTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_ATTRIBUTETEST);
    }
    
    public static boolean isAttributeTest(String expression) {
        return expression.matches(ATTRIBUTETEST_PATTERN);
    }
}
