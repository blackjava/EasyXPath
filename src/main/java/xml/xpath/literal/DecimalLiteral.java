package xml.xpath.literal;

import i18n.ErrorCode;
import xml.xpath.NumberFormatException;

/**
 * A decimal literal is a direct syntactic representation of a number with  
 * fractal parts.
 */
public class DecimalLiteral extends Literal {
    protected static final String DECIMAL_LITERAL_PATTERN = "(\\.[0-9]+|[0-9]+\\.[0-9]*)";
    
    private final Float value;
    
    /**
     * Construct a decimal literal from a string.
     * @throws NumberFormatException if the string is not a valid decimal
     */
    public DecimalLiteral(String value) {
        try {
            this.value = Float.parseFloat(value);
        } catch (java.lang.NumberFormatException nfe) {
            for (int index = 0; index < value.length(); index++) {
                if (!Character.isDigit(value.charAt(index))) {
                    throw new NumberFormatException(nfe, ErrorCode.NUMBER_CONTAINS_INVALID_CHARACTER, value, Integer.toString(index));
                }
            }

            throw new NumberFormatException(nfe, ErrorCode.COULD_NOT_PARSE_DECIMAL, value);
        }
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
    
    public static boolean isDecimalLiteral(String expression) {
        return expression.trim().matches(DECIMAL_LITERAL_PATTERN);
    }
}
