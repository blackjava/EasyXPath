package xml.xpath.nodetest;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

/**
 * An AnyKindTest matches a node of any kind.
 */
public class AnyKindTest implements NodeTest {
    private static final String ANYKINDTEST_PATTERN = "node\\(\\)";
    
    public AnyKindTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_ANYKINDTEST);
    }
    
    public static boolean isAnyKindTest(String expression) {
        return expression.matches(ANYKINDTEST_PATTERN);
    }
}
