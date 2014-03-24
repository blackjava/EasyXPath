package xml.xpath.literal;

import i18n.ErrorCode;
import xml.xpath.NumberFormatException;

/**
 * An integer literal is a direct syntactic representation of a number with no 
 * fractal parts.
 */
public class IntegerLiteral extends Literal {
    protected static final String INTEGER_LITERAL_PATTERN = "[0-9]+";
    
    private final Integer value;
    
    /**
     * Construct an integer literal from a string.
     * @throws NumberFormatException if the string is not a valid integer
     */
    public IntegerLiteral(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (java.lang.NumberFormatException nfe) {
            for (int index = 0; index < value.length(); index++) {
                if (!Character.isDigit(value.charAt(index))) {
                    throw new NumberFormatException(nfe, ErrorCode.NUMBER_CONTAINS_INVALID_CHARACTER, value, Integer.toString(index));
                }
            }
            
            throw new NumberFormatException(nfe, ErrorCode.COULD_NOT_PARSE_INTEGER, value);
        }
    }
    
    @Override
    public String toString() {
        return Integer.toString(value);
    }
    
    public static boolean isIntegerLiteral(String expression) {
        return expression.trim().matches(INTEGER_LITERAL_PATTERN);
    }
}
