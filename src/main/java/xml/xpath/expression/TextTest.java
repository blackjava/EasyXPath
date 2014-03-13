package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A TextTest matches any text element.
 */
public class TextTest implements Expression {
    private static final String TEXTTEST_PATTERN = "text\\(\\)";
    
    public TextTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_TEXTTEST);
    }
    
    public static boolean isTextTest(String expression) {
        return expression.matches(TEXTTEST_PATTERN);
    }
}
