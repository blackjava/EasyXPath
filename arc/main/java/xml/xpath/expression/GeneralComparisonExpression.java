package xml.xpath.expression;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * The general comparison operators are =, !=, <, <=, >, and >=. General 
 * comparisons are existentially quantified comparisons that may be applied to 
 * operand sequences of any length. The result of a general comparison that does 
 * not raise an error is always true or false.
 * 
 * If XPath 1.0 compatibility mode is true, a general comparison is evaluated by 
 * applying the following rules, in order:
 * 
 * If either operand is a single atomic value that is an instance of xs:boolean, 
 * then the other operand is converted to xs:boolean by taking its effective 
 * boolean value.
 * 
 * Atomization is applied to each operand. After atomization, each operand is a 
 * sequence of atomic values.
 * 
 * If the comparison operator is <, <=, >, or >=, then each item in both of the 
 * operand sequences is converted to the type xs:double by applying the 
 * fn:number function. (Note that fn:number returns the value NaN if its operand 
 * cannot be converted to a number.)
 * 
 * The result of the comparison is true if and only if there is a pair of atomic 
 * values, one in the first operand sequence and the other in the second operand 
 * sequence, that have the required magnitude relationship. Otherwise the result 
 * of the comparison is false. The magnitude relationship between two atomic 
 * values is determined by applying the following rules. If a cast operation 
 * called for by these rules is not successful, a dynamic error is raised. 
 * [err:FORG0001]
 * 
 * If at least one of the two atomic values is an instance of a numeric type, 
 * then both atomic values are converted to the type xs:double by applying the 
 * fn:number function.
 * 
 * If at least one of the two atomic values is an instance of xs:string, or if 
 * both atomic values are instances of xs:untypedAtomic, then both atomic values 
 * are cast to the type xs:string.
 * 
 * If one of the atomic values is an instance of xs:untypedAtomic and the other 
 * is not an instance of xs:string, xs:untypedAtomic, or any numeric type, then 
 * the xs:untypedAtomic value is cast to the dynamic type of the other value.
 * 
 * After performing the conversions described above, the atomic values are 
 * compared using one of the value comparison operators eq, ne, lt, le, gt, or 
 * ge, depending on whether the general comparison operator was =, !=, <, <=, >, 
 * or >=. The values have the required magnitude relationship if and only if the 
 * result of this value comparison is true.
 * 
 * If XPath 1.0 compatibility mode is false, a general comparison is evaluated 
 * by applying the following rules, in order:
 * 
 * Atomization is applied to each operand. After atomization, each operand is a 
 * sequence of atomic values.
 * 
 * The result of the comparison is true if and only if there is a pair of atomic 
 * values, one in the first operand sequence and the other in the second operand 
 * sequence, that have the required magnitude relationship. Otherwise the result 
 * of the comparison is false. The magnitude relationship between two atomic 
 * values is determined by applying the following rules. If a cast operation 
 * called for by these rules is not successful, a dynamic error is raised. 
 * [err:FORG0001]
 * 
 * If both atomic values are instances of xs:untypedAtomic, then the values are 
 * cast to the type xs:string.
 * 
 * If exactly one of the atomic values is an instance of xs:untypedAtomic, it is 
 * cast to a type depending on the other value's dynamic type T according to the 
 * following rules, in which V denotes the value to be cast:
 * 
 * If T is a numeric type or is derived from a numeric type, then V is cast to 
 * xs:double.
 * 
 * If T is xs:dayTimeDuration or is derived from xs:dayTimeDuration, then V is 
 * cast to xs:dayTimeDuration.
 * 
 * If T is xs:yearMonthDuration or is derived from xs:yearMonthDuration, then V 
 * is cast to xs:yearMonthDuration.
 * 
 * In all other cases, V is cast to the primitive base type of T.
 * 
 * Note:
 * The special treatment of the duration types is required to avoid errors that 
 * may arise when comparing the primitive type xs:duration with any duration 
 * type.
 * 
 * After performing the conversions described above, the atomic values are 
 * compared using one of the value comparison operators eq, ne, lt, le, gt, or 
 * ge, depending on whether the general comparison operator was =, !=, <, <=, >, 
 * or >=. The values have the required magnitude relationship if and only if the 
 * result of this value comparison is true.
 * 
 * When evaluating a general comparison in which either operand is a sequence of 
 * items, an implementation may return true as soon as it finds an item in the 
 * first operand and an item in the second operand that have the required 
 * magnitude relationship. Similarly, a general comparison may raise a dynamic 
 * error as soon as it encounters an error in evaluating either operand, or in 
 * comparing a pair of items from the two operands. As a result of these rules, 
 * the result of a general comparison is not deterministic in the presence of 
 * errors.
 */
public class GeneralComparisonExpression implements Expression {
    private static final String GENERALCOMPARISONEXPRESSION_PATTERN = "(\\=|\\!\\=|\\<|\\<\\=|\\>|\\>\\=)";

    public GeneralComparisonExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_GENERALCOMPARISON);
    }
    
    public static boolean isGeneralComparisonExpression(String expression) {
        return expression.matches(GENERALCOMPARISONEXPRESSION_PATTERN);
    }
}
