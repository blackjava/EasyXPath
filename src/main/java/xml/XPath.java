package xml;

import static i18n.ErrorCode.EMPTY_EXPRESSION;
import java.util.ArrayList;
import java.util.List;
import text.ContextSensitiveTokenizer;
import static text.StringUtilities.isEmpty;
import xml.xpath.Step;

/**
 * X-path is a path notation for navigating through the hierarchical structure 
 * of an XML document. An x-path expression consists of a series of steps that
 * are resolved from left to right.
 */
public class XPath {
    private List<Step> steps = new ArrayList<>();
    
    private XPath(List<Step> steps) {
        this.steps = steps;
    }
    
    static XPath parse(String expression) throws InvalidExpressionException {
        if (isEmpty(expression)) {
            throw new InvalidExpressionException(EMPTY_EXPRESSION);
        }
        
        List<Step> steps = new ArrayList<>();
        
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer(expression, '/');
        for (String token = tokenizer.nextToken(); token != null; token = tokenizer.nextToken()) {
            steps.add(Step.parse(token));
        }
        
        return new XPath(steps);
    }

    public int length() {
        return steps.size();
    }
}
