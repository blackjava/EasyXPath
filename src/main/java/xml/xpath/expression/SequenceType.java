package xml.xpath.expression;

import static xml.xpath.expression.OccurrenceIndicator.OCCURRENCEINDICATOR_PATTERN;
import static xml.xpath.expression.ItemType.PARENTHESIZEDITEMTYPE_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * A sequence type is a type that can be expressed using the SequenceType syntax. 
 * Sequence types are used whenever it is necessary to refer to a type in an 
 * XPath 3.0 expression. The term sequence type suggests that this syntax is 
 * used to describe the type of an XPath 3.0 value, which is always a sequence.
 */
public class SequenceType implements Expression {
    protected static final String SEQUENCETYPE_PATTERN = "(empty\\-sequence\\(\\)|" 
            + PARENTHESIZEDITEMTYPE_PATTERN + "(" + OCCURRENCEINDICATOR_PATTERN + ")?" + ")";
    
    public SequenceType() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_SEQUENCETYPE);
    }
    
    public static boolean isSequenceType(String expression) {
        return expression.matches(SEQUENCETYPE_PATTERN);
    }
}
