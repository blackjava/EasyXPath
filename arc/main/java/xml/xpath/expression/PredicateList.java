package xml.xpath.expression;

import static xml.xpath.expression.Predicate.PREDICATE_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * A predicate list is a sequence of zero or more predicates.
 */
public class PredicateList implements Expression {
    private static final String PREDICATELIST_PATTERN = "(" + PREDICATE_PATTERN + ")*";
    
    public PredicateList() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_PREDICATELIST);
    }
    
    public static boolean isPredicateList(String expression) {
        return expression.matches(PREDICATELIST_PATTERN);
    }
}
