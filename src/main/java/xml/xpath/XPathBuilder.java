package xml.xpath;

import i18n.ErrorCode;
import xml.xpath.expression.ForExpression;
import xml.xpath.expression.IfExpression;
import xml.xpath.expression.LetExpression;
import xml.xpath.expression.OrExpression;
import xml.xpath.expression.QuantifiedExpression;
import xml.xpath.expression.UnsupportedExpressionException;

/**
 * The XPathBuilder compiles an x-path notation and returns an executable
 * x-path expression.
 */
public class XPathBuilder {
    public Expression compile(String expression) {
        if (ForExpression.isForExpression(expression)) {
            return new ForExpression();
        } else if (LetExpression.isLetExpression(expression)) {
            return new LetExpression();
        } else if (QuantifiedExpression.isQuantifiedExpression(expression)) {
            return new QuantifiedExpression();
        } else if (IfExpression.isIfExpression(expression)) {
            return new IfExpression();
        } else if (OrExpression.isOrExpression(expression)) {
            return new OrExpression();
        }

        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_EXPRESSION_UNKNOWN, expression);
    }
    
}
