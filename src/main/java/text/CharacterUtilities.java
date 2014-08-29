package text;

/**
 * Utility functionality for working with characters.
 */
public final class CharacterUtilities {
    private CharacterUtilities() {}

    public static boolean isOpeningCurlyBracket(Character character) {
        return character.equals('{');
    }

    public static boolean isOpeningParenthesis(Character character) {
        return character.equals('(');
    }

    public static boolean isClosingCurlyBracket(Character character) {
        return character.equals('}');
    }

    public static boolean isClosingParenthesis(Character character) {
        return character.equals(')');
    }

    public static boolean isOpeningSquareBracket(Character character) {
        return character.equals('[');
    }

    public static boolean isClosingSquareBracket(Character character) {
        return character.equals(']');
    }

    public static boolean isQuote(Character character) {
        return character.equals('\'') || character.equals('"');
    }
    
    public static boolean isSymbol(Character character) {
        return (!Character.isLetterOrDigit(character) && !Character.isWhitespace(character));
    }
}
