package xml.xpath.expression;

import static xml.xpath.expression.ForExpression.FOR_EXPRESSION_PATTERN;
import static xml.xpath.expression.LetExpression.LET_EXPRESSION_PATTERN;
import static xml.xpath.expression.QuantifiedExpression.QUANTIFIED_EXPRESSION_PATTERN;
import static xml.xpath.expression.IfExpression.IF_EXPRESSION_PATTERN;
import static xml.xpath.expression.OrExpression.OR_EXPRESSION_PATTERN;

import i18n.ErrorCode;
import xml.xpath.UnsupportedExpressionException;

/**
 * An expression single is an expression that is not allowed to contain a 
 * top-level comma. For example, each of the arguments of a function call must 
 * be an ExprSingle, because commas are used to separate the arguments of a 
 * function call.
 */
public class ExpressionSingle {
    private static final String EXPRESSIONSINGLE_PATTERN = "(" + 
                                    FOR_EXPRESSION_PATTERN + "|" + 
                                    LET_EXPRESSION_PATTERN + "|" + 
                                    QUANTIFIED_EXPRESSION_PATTERN + "|" + 
                                    IF_EXPRESSION_PATTERN + "|" +
                                    OR_EXPRESSION_PATTERN + ")";
    
    public ExpressionSingle() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_EXPRESSIONSINGLE);
    }

    public static boolean isExpressionSingle(String expression) {
        return expression.matches(EXPRESSIONSINGLE_PATTERN);
    }
}
