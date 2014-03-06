package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A postfix expression is an expression followed by one or more postfixes.
 * 
 * An expression followed by a predicate is referred to as a filter expression: 
 * its effect is to return those items from the value that satisfy the predicate.
 * 
 * An expression followed by an argument list in parentheses is referred to as a 
 * dynamic function call. Its effect is to evaluate the expression to obtain a 
 * function, and then call that function with the argument list.
 */
public class PostfixExpression implements Expression {
    private static final String NODE_NAME_PATTERN = "[A-Z|a-z]([A-Z|a-z|0-9]|'.'|'_'|'-')*";
    

    private static final String EXPRESSION_PATTERN = "";
    
    
    private static final String INTEGER_LITERAL = "[0-9]+";
    private static final String DECIMAL_LITERAL = "(\\.[0-9]+|[0-9]+\\.[0-9]*)";
    private static final String DOUBLE_LITERAL = "(\\.[0-9]+|[0-9]+(\\.[0-9]*)?)[e|E](\\+|\\-)?[0-9]+";
    private static final String NUMERIC_LITERAL = "(" + INTEGER_LITERAL + "|" + DECIMAL_LITERAL + "|" + DOUBLE_LITERAL + ")";
    private static final String STRING_LITERAL = "";
    private static final String LITERAL_PATTERN = "(" + NUMERIC_LITERAL + "|" + STRING_LITERAL + ")";
    private static final String VARIABLE_NAME_PATTERN = "";
    private static final String VARIABLE_REFERENCE_PATTERN = "\\$" + VARIABLE_NAME_PATTERN;
    private static final String PARENTHESIZED_EXPRESSION_PATTERN = "\\(" + EXPRESSION_PATTERN + "\\)";
    private static final String CONTEXT_ITEM_PATTERN = "\\.";
    private static final String ARGUMENT_LIST_PATTERN = "";
    private static final String FUNCTION_CALL_PATTERN = NODE_NAME_PATTERN + ARGUMENT_LIST_PATTERN;
    private static final String FUNCTION_ITEM_PATTERN = "";
    
    private static final String PRIMARY_EXPRESSION_PATTERN = "(" + LITERAL_PATTERN + "|" + VARIABLE_REFERENCE_PATTERN + "|" + PARENTHESIZED_EXPRESSION_PATTERN 
            + "|" + CONTEXT_ITEM_PATTERN + "|" + FUNCTION_CALL_PATTERN + "|" + FUNCTION_ITEM_PATTERN + ")";
    
    protected static final String POSTFIX_EXPRESSION_PATTERN = PRIMARY_EXPRESSION_PATTERN;
    
    

    public PostfixExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_POSTFIX);
    }

    public static boolean isPostfixExpression(String expression) {
        return expression.matches(POSTFIX_EXPRESSION_PATTERN);
    }
}
