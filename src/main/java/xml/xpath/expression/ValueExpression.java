package xml.xpath.expression;

import i18n.ErrorCode;
import static xml.xpath.expression.PathExpression.PATH_EXPRESSION_PATTERN;

/**
 * A value expression is an operand used in an arithmetic expression. 
 * The expression evaluates to an atomic value according to the rules of 
 * atomization. 
 * 
 * If the atomization results in an empty sequence, the result of the arithmetic 
 * expression is the xs:double value NaN.
 * 
 * If the atomization results in a sequence of length greater than one, any 
 * items after the first item in the sequence are discarded.
 * 
 * If the atomization results in a value of type xs:boolean, xs:string, 
 * xs:decimal, xs:integer, xs:float or xs:untypedAtomic, then it is converted to 
 * the type xs:double by applying the fn:number function;
 */
public class ValueExpression {
    private static final String VALUE_EXPRESSION_PATTERN = PATH_EXPRESSION_PATTERN + "( ! " + PATH_EXPRESSION_PATTERN + ")*";

    public ValueExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_VALUE);
    }
    
    public static boolean isValueExpression(String expression) {
        return expression.matches(VALUE_EXPRESSION_PATTERN);
    }
}
