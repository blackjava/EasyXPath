package xml.xpath.expression;

import i18n.ErrorCode;

/**
 * A braced URI literal is an expanded namespace. The expanded namespace 
 * uniquely defines the properties of the element within the scope of the 
 * document.
 */
public class BracedUriLiteral extends Literal {
    private static final String BRACEDURI_LITERAL_PATTERN = "Q\\{[^\\{\\}]*\\}";
    
    public BracedUriLiteral() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_LITERAL_BRACEDURI);
    }
    
    public static boolean isBracedUriLiteral(String expression) {
        return expression.matches(BRACEDURI_LITERAL_PATTERN);
    }
}