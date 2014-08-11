package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

public class OccurrenceIndicator implements Expression {
    protected static final String OCCURRENCEINDICATOR_PATTERN = "(\\?|\\*|\\+)";
    
    public OccurrenceIndicator() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_OCCURRENCEINDICATOR);
    }
    
    public static boolean isOccurrenceIndicator(String expression) {
        return expression.matches(OCCURRENCEINDICATOR_PATTERN);
    }
}
