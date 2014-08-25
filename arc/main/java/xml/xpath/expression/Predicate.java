package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * A predicate is an expression written in square brackets, used to define
 * conditions for a filter expression or step.
 * 
 * For each item in the input sequence, the predicate expression is evaluated 
 * using an inner focus, defined as follows: The context item is the item 
 * currently being tested against the predicate. The context size is the number 
 * of items in the input sequence. The context position is the position of the 
 * context item within the input sequence.
 * 
 * For each item in the input sequence, the result of the predicate expression 
 * is coerced to an xs:boolean value, called the predicate truth value, as 
 * described below. Those items for which the predicate truth value is true are 
 * retained, and those for which the predicate truth value is false are 
 * discarded.
 * 
 * The predicate truth value is derived by applying the following rules, in 
 * order:
 * 
 * 1. If the value of the predicate expression is a singleton atomic value of a 
 * numeric type or derived from a numeric type, the predicate truth value is 
 * true if the value of the predicate expression is equal (by the eq operator) 
 * to the context position, and is false otherwise. A predicate whose predicate 
 * expression returns a numeric type is called a numeric predicate.
 * 
 * 2. Otherwise, the predicate truth value is the effective boolean value of the 
 * predicate expression.
 * 
 * A predicate within a Step has similar syntax and semantics to a predicate 
 * within a filter expression. The only difference is in the way the context 
 * position is set for evaluation of the predicate.
 * 
 * For the purpose of evaluating the context position within a predicate, the 
 * input sequence is considered to be sorted as follows: into document order if 
 * the predicate is in a forward-axis step, into reverse document order if the 
 * predicate is in a reverse-axis step, or in its original order if the 
 * predicate is not in a step.
 * 
 * When using predicates with a sequence of nodes selected using a reverse axis, 
 * it is important to remember that the context positions for such a sequence 
 * are assigned in reverse document order. For example, preceding::foo[1] 
 * returns the first qualifying foo element in reverse document order, because 
 * the predicate is part of an axis step using a reverse axis. By contrast, 
 * (preceding::foo)[1] returns the first qualifying foo element in document 
 * order, because the parentheses cause (preceding::foo) to be parsed as a 
 * primary expression in which context positions are assigned in document order. 
 * Similarly, ancestor::*[1] returns the nearest ancestor element, because the 
 * ancestor axis is a reverse axis, whereas (ancestor::*)[1] returns the root 
 * element (first ancestor in document order).
 * 
 * The fact that a reverse-axis step assigns context positions in reverse 
 * document order for the purpose of evaluating predicates does not alter the 
 * fact that the final result of the step is always in document order.
 */
public class Predicate implements Expression {
    protected static final String PREDICATE_PATTERN = "\\[\\]";
    
    public Predicate() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_PREDICATE);
    }
    
    public static boolean isPredicate(String expression) {
        return expression.matches(PREDICATE_PATTERN);
    }
}
