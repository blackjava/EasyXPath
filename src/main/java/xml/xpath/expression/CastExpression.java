package xml.xpath.expression;

import static xml.xpath.expression.SingleType.SINGLETYPE_PATTERN;
import static xml.xpath.expression.UnaryExpression.UNARYEXPRESSION_PATTERN;

import i18n.ErrorCode;
import xml.xpath.Expression;
import xml.xpath.UnsupportedExpressionException;

/**
 * Occasionally it is necessary to convert a value to a specific datatype. For 
 * this purpose, XPath 3.0 provides a cast expression that creates a new value 
 * of a specific type based on an existing value. A cast expression takes two 
 * operands: an input expression and a target type. The type of the atomized 
 * value of the input expression is called the input type. The SimpleTypeName 
 * must be the name of a type defined in the in-scope schema types, and it must 
 * be a simple type [err:XQST0052]. In addition, the target type cannot be 
 * xs:NOTATION , xs:anySimpleType, or xs:anyAtomicType [err:XPST0080]. The 
 * optional occurrence indicator "?" denotes that an empty sequence is 
 * permitted. If the target type is a lexical QName that has no namespace 
 * prefix, it is considered to be in the default element/type namespace.
 * 
 * Casting a node to xs:QName can cause surprises because it uses the static 
 * context of the cast expression to provide the namespace bindings for this 
 * operation. Instead of casting to xs:QName, it is generally preferable to use 
 * the fn:QName function, which allows the namespace context to be taken from 
 * the document containing the QName.
 * 
 * The semantics of the cast expression are as follows:
 * 
 * The input expression is evaluated.
 * The result of the first step is atomized.
 * 
 * If the result of atomization is a sequence of more than one atomic value, a 
 * type error is raised [err:XPTY0004].
 * 
 * If the result of atomization is an empty sequence:
 * If ? is specified after the target type, the result of the cast expression is 
 * an empty sequence.
 * If ? is not specified after the target type, a type error is raised 
 * [err:XPTY0004].
 * 
 * If the result of atomization is a single atomic value, the result of the cast 
 * expression depends on the input type and the target type. In general, the 
 * cast expression attempts to create a new value of the target type based on 
 * the input value. Only certain combinations of input type and target type are 
 * supported. A summary of the rules are listed below—the normative definition 
 * of these rules is given in [XQuery and XPath Functions and Operators 3.0]. 
 * For the purpose of these rules, an implementation may determine that one type 
 * is derived by restriction from another type either by examining the in-scope 
 * schema definitions or by using an alternative, implementation-dependent 
 * mechanism such as a data dictionary.
 * 
 * cast is supported for the combinations of input type and target type listed 
 * in Section 18.1 Casting from primitive types to primitive types FO30. For 
 * each of these combinations, both the input type and the target type are 
 * primitive schema types. For example, a value of type xs:string can be cast 
 * into the schema type xs:decimal. For each of these built-in combinations, the 
 * semantics of casting are specified in [XQuery and XPath Functions and 
 * Operators 3.0].
 * 
 * cast is supported if the input type is a non-primitive atomic type that is 
 * derived by restriction from the target type. In this case, the input value 
 * is mapped into the value space of the target type, unchanged except for its 
 * type. For example, if shoesize is derived by restriction from xs:integer, a 
 * value of type shoesize can be cast into the schema type xs:integer.
 * 
 * cast is supported if the target type is a non-primitive atomic type and the 
 * input type is xs:string or xs:untypedAtomic. The input value is first 
 * converted to a value in the lexical space of the target type by applying the 
 * whitespace normalization rules for the target type (as defined in 
 * [XML Schema 1.0] or [XML Schema 1.1]). The lexical value is then converted to 
 * the value space of the target type using the schema-defined rules for the 
 * target type. If the input value fails to satisfy some facet of the target 
 * type, a dynamic error may be raised as specified in [XQuery and XPath 
 * Functions and Operators 3.0].
 * 
 * cast is supported to any target type if the input type is xs:string or 
 * xs:untypedAtomic. The target type may be an atomic type, a union type, or a 
 * list type. The semantics are based on the rules for validation in 
 * [XML Schema 1.0] or [XML Schema 1.1].
 * 
 * The effect of casting a string S to a simple type T is the same as 
 * constructing an element or attribute node whose string value is S, validating 
 * it using T as the governing type, and atomizing the resulting node. The 
 * result may be a single atomic value or (if list types are involved) a 
 * sequence of zero or more atomic values.
 * 
 * If the target type is namespace-sensitive, then the namespace bindings in the 
 * static context will be used to resolve any namespace prefix found in the 
 * supplied string.
 * 
 * cast is supported if the target type is a non-primitive atomic type that is 
 * derived by restriction from the input type. The input value must satisfy all 
 * the facets of the target type (in the case of the pattern facet, this is 
 * checked by generating a string representation of the input value, using the 
 * rules for casting to xs:string). The resulting value is the same as the input 
 * value, but with a different dynamic type.
 * 
 * If a primitive type P1 can be cast into a primitive type P2, then any type 
 * derived by restriction from P1 can be cast into any type derived by 
 * restriction from P2, provided that the facets of the target type are 
 * satisfied. First the input value is cast to P1 using rule (b) above. Next, 
 * the value of type P1 is cast to the type P2, using rule (a) above. Finally, 
 * the value of type P2 is cast to the target type, using rule (d) above.
 * 
 * For any combination of input type and target type that is not in the above 
 * list, a cast expression raises a type error [err:XPTY0004].
 * 
 * If casting from the input type to the target type is supported but 
 * nevertheless it is not possible to cast the input value into the value space 
 * of the target type, a dynamic error is raised. [err:FORG0001] This includes 
 * the case when any facet of the target type is not satisfied. For example, the 
 * expression "2003-02-31" cast as xs:date would raise a dynamic error.
 */
public class CastExpression implements Expression {
    private static final String CASTEXPRESSION_PATTERN = UNARYEXPRESSION_PATTERN + "( cast as " + SINGLETYPE_PATTERN + ")?";
    
    public CastExpression() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_CASTEXPRESSION);
    }
    
    public static boolean isCastExpression(String expression) {
        return expression.matches(CASTEXPRESSION_PATTERN);
    }
}
