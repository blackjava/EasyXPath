package xml.xpath.expression;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

public class AttributeTest implements Expression {
    private static final String ATTRIBUTETEST_PATTERN = "attribute\\(((" + EQNAME_PATTERN + "|\\*)(," + EQNAME_PATTERN + ")?)?\\)";
    
    public AttributeTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_ATTRIBUTETEST);
    }
    
    public static boolean isAttributeTest(String expression) {
        return expression.matches(ATTRIBUTETEST_PATTERN);
    }
}
