package xml.xpath.expression;

import static xml.xpath.nodetest.KindTest.KINDTEST_PATTERN;
import static xml.xpath.nodetest.FunctionTest.FUNCTIONTEST_PATTERN;
import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * ItemType is a term used to define any item of type atomic, node or function.
 * An ItemType consisting simply of an EQName is interpreted as an 
 * AtomicOrUnionType. The expected type AtomicOrUnionType matches an atomic 
 * value whose actual type is AT if derives-from( AT, AtomicOrUnionType ) is 
 * true.
 * 
 * The name of an AtomicOrUnionType has its prefix expanded to a namespace URI 
 * by means of the statically known namespaces, or if unprefixed, the default 
 * element/type namespace. If the expanded QName of an AtomicOrUnionType is not 
 * defined as a generalized atomic type in the in-scope schema types, a static 
 * error is raised [err:XPST0051].
 * 
 * Example: The ItemType xs:decimal matches any value of type xs:decimal. It 
 * also matches any value of type shoesize, if shoesize is an atomic type 
 * derived by restriction from xs:decimal.
 * 
 * Example: Suppose ItemType dress-size is a union type that allows either 
 * xs:decimal values for numeric sizes (e.g. 4, 6, 10, 12), or one of an 
 * enumerated set of xs:strings (e.g. "small", "medium", "large"). The ItemType 
 * dress-size matches any of these values.
 * 
 * Note:
 * The names of non-atomic types such as xs:IDREFS are not accepted in this 
 * context, but can often be replaced by a generalized atomic type with an 
 * occurrence indicator, such as xs:IDREF+.
 * 
 * item() matches any single item.
 * Example: item() matches the atomic value 1, the element <a/>, or the function 
 * fn:concat#3.
 * 
 * node() matches any node.
 * 
 * text() matches any text node.
 * 
 * processing-instruction() matches any processing-instruction node.
 * 
 * processing-instruction( N ) matches any processing-instruction node whose 
 * PITarget is equal to fn:normalize-space(N). If fn:normalize-space(N) is not 
 * in the lexical space of NCName, a type error is raised [err:XPTY0004]
 * Example: processing-instruction(xml-stylesheet) matches any processing 
 * instruction whose PITarget is xml-stylesheet.
 * 
 * For backward compatibility with XPath 1.0, the PITarget of a processing 
 * instruction may also be expressed as a string literal, as in this example: 
 * processing-instruction("xml-stylesheet").
 * 
 * If the specified PITarget is not a syntactically valid NCName, a type error 
 * is raised [err:XPTY0004].
 * 
 * comment() matches any comment node.
 * 
 * namespace-node() matches any namespace node.
 * 
 * document-node() matches any document node.
 * 
 * document-node( E ) matches any document node that contains exactly one 
 * element node, optionally accompanied by one or more comment and processing 
 * instruction nodes, if E is an ElementTest or SchemaElementTest that matches 
 * the element node (see 2.5.5.3 Element Test and 2.5.5.4 Schema Element Test).
 * Example: document-node(element(book)) matches a document node containing 
 * exactly one element node that is matched by the ElementTest element(book).
 * 
 * A ParenthesizedItemType matches an item if and only if the item matches the 
 * ItemType that is in parentheses.
*/
public class ItemType implements Expression {
    private static final String ITEMTYPE_PATTERN = "(" + KINDTEST_PATTERN + "|item\\(\\)|" + FUNCTIONTEST_PATTERN + "|" + EQNAME_PATTERN + ")";
    protected static final String PARENTHESIZEDITEMTYPE_PATTERN = "(" + ITEMTYPE_PATTERN + "|\\(" + ITEMTYPE_PATTERN + "\\))";
    
    public ItemType() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_ITEMTYPE);
    }
    
    public static boolean isItemType(String expression) {
        return expression.matches(PARENTHESIZEDITEMTYPE_PATTERN);
    }
}
