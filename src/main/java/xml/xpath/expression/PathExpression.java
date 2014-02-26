package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;

/**
 * A path expression denotes a node location within a tree. The path consists of 
 * a series of one or more steps, separated by / or //, and optionally beginning 
 * with / or //. An initial / or // is an abbreviation for one or more initial 
 * steps that are implicitly added to the beginning of the path expression.
 * 
 * A / at the beginning of a path expression is an abbreviation for the initial 
 * step "(fn:root(self::node()) treat as document-node())". The effect of this 
 * initial step is to begin the path at the root node of the tree that contains 
 * the context node.
 * 
 * A // at the beginning of a path expression is an abbreviation for the initial 
 * steps "(fn:root(self::node()) treat as document-node())/descendant-or-self::node()".
 * The effect of these initial steps is to establish an initial node sequence 
 * that contains the root of the tree in which the context node is found, plus
 * all nodes descended from this root.
 */
public class PathExpression implements Expression {
    private static final String NODE_NAME_PATTERN = "[A-Z|a-z]([A-Z|a-z|0-9]|'.'|'_'|'-')*";
    protected static final String PATH_EXPRESSION_PATTERN = "\\/?\\/?" + NODE_NAME_PATTERN + "(\\/" + NODE_NAME_PATTERN + ")*";

    public PathExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_PATH);
    }
    
    /**
     * Determines if the specified string is a path expression.
     */
    public static boolean isPathExpression(String expression) {
        return expression.matches(PATH_EXPRESSION_PATTERN);
    }
}
