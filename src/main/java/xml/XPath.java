package xml;

import static i18n.ErrorCode.EMPTY_EXPRESSION;
import static text.StringUtilities.isEmpty;

/**
 * XPath is a path notation for navigating through the hierarchical structure 
 * of an XML document.
 */
public class XPath {
    private XPath() {}
    
    static XPath parse(String expression) throws InvalidExpressionException {
        if (isEmpty(expression)) {
            throw new InvalidExpressionException(EMPTY_EXPRESSION);
        }
        
        return null;
    }

}
