package xml.xpath.expression;

import static xml.xpath.expression.PostfixExpression.POSTFIX_EXPRESSION_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A step is a part of a path expression that generates a sequence of items and 
 * then filters the sequence by zero or more predicates. The value of the step 
 * consists of those items that satisfy the predicates, working from left to 
 * right.
 */
public class StepExpression implements Expression {
    protected static final String STEP_EXPRESSION_PATTERN = POSTFIX_EXPRESSION_PATTERN;
    
    public StepExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_STEP);
    }
    
    public static boolean isStepExpression(String expression) {
        return expression.matches(STEP_EXPRESSION_PATTERN);
    }
}
