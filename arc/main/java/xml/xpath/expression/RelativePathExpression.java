package xml.xpath.expression;

import static xml.xpath.expression.StepExpression.STEP_EXPRESSION_PATTERN;
import xml.xpath.Expression;

/**
 * A relative path expression denotes a node location relative to the current 
 * position. The path consists of a series of one or more steps, separated by / 
 * or //. 
 * 
 * Each occurrence of // is replaced by "/descendant-or-self::node()/", 
 * leaving a sequence of steps separated by /. 
 * 
 * This sequence is then evaluated from left to right. The result of evaluating 
 * each item is then used as the context item for the next evaluation.
 */
public class RelativePathExpression implements Expression {
    protected static final String RELATIVEPATH_EXPRESSION_PATTERN = STEP_EXPRESSION_PATTERN + "(\\/\\/?" + STEP_EXPRESSION_PATTERN + ")*";

    public static boolean isRelativePathExpression(String expression) {
        return expression.matches(RELATIVEPATH_EXPRESSION_PATTERN);
    }
}
