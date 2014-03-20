package xml.xpath.nodetest;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * A TextTest matches any text element.
 */
public class TextTest implements NodeTest {
    private static final String TEXTTEST_PATTERN = "text\\(\\)";
    
    public TextTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_TEXTTEST);
    }
    
    public static boolean isTextTest(String expression) {
        return expression.matches(TEXTTEST_PATTERN);
    }
}
