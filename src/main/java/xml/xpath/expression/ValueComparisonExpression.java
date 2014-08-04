package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * The value comparison operators are eq, ne, lt, le, gt, and ge. Value 
 * comparisons are used for comparing single values.
 * 
 * The first step in evaluating a value comparison is to evaluate its operands. 
 * The order in which the operands are evaluated is implementation-dependent. 
 * Each operand is evaluated by applying the following steps, in order:
 * 
 * Atomization is applied to the operand. The result of this operation is called 
 * the atomized operand.
 * 
 * If the atomized operand is an empty sequence, the result of the value 
 * comparison is an empty sequence, and the implementation need not evaluate the 
 * other operand or apply the operator. However, an implementation may choose to 
 * evaluate the other operand in order to determine whether it raises an error.
 * 
 * If the atomized operand is a sequence of length greater than one, a type 
 * error is raised [err:XPTY0004].
 * 
 * If the atomized operand is of type xs:untypedAtomic, it is cast to xs:string.
 * 
 * Note:
 * The purpose of this rule is to make value comparisons transitive. Users 
 * should be aware that the general comparison operators have a different rule 
 * for casting of xs:untypedAtomic operands. Users should also be aware that 
 * transitivity of value comparisons may be compromised by loss of precision 
 * during type conversion (for example, two xs:integer values that differ 
 * slightly may both be considered equal to the same xs:float value because 
 * xs:float has less precision than xs:integer).
 * 
 * Next, if possible, the two operands are converted to their least common type 
 * by a combination of type promotion and subtype substitution. For example, if 
 * the operands are of type hatsize (derived from xs:integer) and shoesize 
 * (derived from xs:float), their least common type is xs:float.
 * 
 * Finally, if the types of the operands are a valid combination for the given 
 * operator, the operator is applied to the operands. The combinations of atomic 
 * types that are accepted by the various value comparison operators, and their 
 * respective result types, are listed in B.2 Operator Mapping together with the 
 * operator functions that define the semantics of the operator for each type 
 * combination. The definitions of the operator functions are found in [XQuery 
 * and XPath Functions and Operators 3.0].
 * 
 * Informally, if both atomized operands consist of exactly one atomic value, 
 * then the result of the comparison is true if the value of the first operand 
 * is (equal, not equal, less than, less than or equal, greater than, greater 
 * than or equal) to the value of the second operand; otherwise the result of 
 * the comparison is false.
 * 
 * If the types of the operands, after evaluation, are not a valid combination 
 * for the given operator, according to the rules in B.2 Operator Mapping, a 
 * type error is raised [err:XPTY0004].
 */
public class ValueComparisonExpression implements Expression {
    private static final String VALUECOMPARISONEXPRESSION_PATTERN = "(eq|ne|lt|le|gt|ge)";
    
    public ValueComparisonExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_VALUECOMPARISON);
    }
    
    public static boolean isValueComparisonExpression(String expression) {
        return expression.matches(VALUECOMPARISONEXPRESSION_PATTERN);
    }
}
