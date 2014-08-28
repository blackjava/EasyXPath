package text;

/**
 * Utility functionality for working with characters.
 */
public final class CharacterUtilities {
    private CharacterUtilities() {}

    static boolean isOpeningCurlyBracket(Character character) {
        return character.equals('{');
    }

    static boolean isOpeningParenthesis(Character character) {
        return character.equals('(');
    }

    static boolean isClosingCurlyBracket(Character character) {
        return character.equals('}');
    }

    static boolean isClosingParenthesis(Character character) {
        return character.equals(')');
    }

    static boolean isOpeningSquareBracket(Character character) {
        return character.equals('[');
    }

    static boolean isClosingSquareBracket(Character character) {
        return character.equals(']');
    }

    static boolean isQuote(Character character) {
        return character.equals('\'') || character.equals('"');
    }
    
    static boolean isSymbol(Character character) {
        return (!Character.isLetterOrDigit(character) && !Character.isWhitespace(character));
    }
}
