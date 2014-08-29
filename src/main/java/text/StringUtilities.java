package text;

/**
 * Utility functionality for working with strings.
 */
public final class StringUtilities {
    private StringUtilities() {}

    public static boolean isEmpty(String expression) {
        return ((expression == null) || (expression.isEmpty()));
    }
}
