package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * An AnyKindTest matches a node of any kind.
 */
public class AnyKindTest implements Expression {
    private static final String ANYKINDTEST_PATTERN = "node\\(\\)";
    
    public AnyKindTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_ANYKINDTEST);
    }
    
    public static boolean isAnyKindTest(String expression) {
        return expression.matches(ANYKINDTEST_PATTERN);
    }
}
