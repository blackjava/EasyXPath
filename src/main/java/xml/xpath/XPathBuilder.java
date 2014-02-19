package xml.xpath;

import xml.xpath.expression.ForExpression;
import xml.xpath.expression.IfExpression;
import xml.xpath.expression.LetExpression;
import xml.xpath.expression.OrExpression;
import xml.xpath.expression.QuantifiedExpression;

/**
 * The XPathBuilder compiles an x-path expression and returns an executable
 * x-path expression.
 */
public class XPathBuilder {
    public Expression compile(String xpath) {
        if (ForExpression.isForExpression(xpath)) {
            return new ForExpression();
        } else if (LetExpression.isLetExpression(xpath)) {
            return new LetExpression();
        } else if (QuantifiedExpression.isQuantifiedExpression(xpath)) {
            return new QuantifiedExpression();
        } else if (IfExpression.isIfExpression(xpath)) {
            return new IfExpression();
        }

        return new OrExpression();
    }
    
}
