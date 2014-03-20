package xml.xpath.expression;

import xml.xpath.UnsupportedExpressionException;
import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A context item expression evaluates to the context item, which may be either 
 * a node (as in the expression fn:doc("bib.xml")/books/book[fn:count(./author)>1]), 
 * or an atomic value or function (as in the expression (1 to 100)[. mod 5 eq 0]).
 */
public class ContextItemExpression implements Expression {
    private static final String CONTEXTITEM_PATTERN = "\\.";
    
    public ContextItemExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_CONTEXTITEM);
    }
    
    public static boolean isContextItemExpression(String expression) {
        return expression.matches(CONTEXTITEM_PATTERN);
    }
}
