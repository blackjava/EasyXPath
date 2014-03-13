package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A NamespaceNodeTest matches any namespace element. If a NamespaceNodeTest is
 * the node test of an axis step, a static error is raised [err:XQST0134].
 */
public class NamespaceNodeTest implements Expression {
    private static final String NAMESPACENODETEST_PATTERN = "namespace\\-node\\(\\)";
    
    public NamespaceNodeTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_NAMESPACENODETEST);
    }
    
    public static boolean isNamespaceNodeTest(String expression) {
        return expression.matches(NAMESPACENODETEST_PATTERN);
    }
}
