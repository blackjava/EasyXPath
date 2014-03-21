package xml.xpath.nodetest;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * A CommentTest matches any comment element.
 */
public class CommentTest implements NodeTest {
    private static final String COMMENTTEST_PATTERN = "comment\\(\\)";
    
    public CommentTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_COMMENTTEST);
    }
    
    public static boolean isCommentTest(String expression) {
        return expression.matches(COMMENTTEST_PATTERN);
    }
}
