package xml.xpath.nodetest;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

public class FunctionTest implements NodeTest {
    public static final String FUNCTIONTEST_PATTERN = "(function\\(\\*\\)|function\\(" + "\\) as " + ")";
    
    public FunctionTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_FUNCTIONTEST);
    }
    
    public static boolean isFunctionTest(String expression) {
        return expression.matches(FUNCTIONTEST_PATTERN);
    }
}
