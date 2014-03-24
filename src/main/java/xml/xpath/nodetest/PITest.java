package xml.xpath.nodetest;

import static xml.xpath.expression.NCName.NCNAME_PATTERN;
import static xml.xpath.literal.StringLiteral.STRING_LITERAL_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * A PITest is used to match a processing-instruction node by its target.
 * 
 * processing-instruction() matches any processing-instruction node.
 * 
 * processing-instruction( N ) matches any processing-instruction node whose 
 * PITarget is equal to fn:normalize-space(N). If fn:normalize-space(N) is not 
 * in the lexical space of NCName, a type error is raised [err:XPTY0004]
 * 
 * Example: processing-instruction(xml-stylesheet) matches any processing 
 * instruction whose PITarget is xml-stylesheet.
 * 
 * For backward compatibility with XPath 1.0, the PITarget of a processing 
 * instruction may also be expressed as a string literal, as in this example: 
 * processing-instruction("xml-stylesheet").
 * 
 * If the specified PITarget is not a syntactically valid NCName, a type error 
 * is raised [err:XPTY0004].
 */
public class PITest implements NodeTest {
    private static final String PITEST_PATTERN = "processing-instruction\\((" + NCNAME_PATTERN + "|" + STRING_LITERAL_PATTERN + ")?\\)";
    
    public PITest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_PITEST);
    }
    
    public static boolean isPITest(String expression) {
        return expression.matches(PITEST_PATTERN);
    }
}
