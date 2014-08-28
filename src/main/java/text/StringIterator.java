package text;

import static text.CharacterUtilities.*;

import java.util.Iterator;

/**
 * Iterates over the characters in a string.
 */
public class StringIterator implements Iterator<Character> {
    private final String string;
    private int index = 0;

    public StringIterator(String string) {
        if (string == null) {
            this.string = "";
        } else {
            this.string = string.trim();
        }
    }

    @Override
    public boolean hasNext() {
        return (index < string.length());
    }

    private boolean insideQuotes = false;
    private int parenthesesLevel = 0;
    private int squareBracketLevel = 0;
    private int curlyBracketLevel = 0;
    
    @Override
    public Character next() {
        Character character = null;

        if (hasNext()) {
            character = string.charAt(index++);

            if (isSymbol(character)) {
                updateIteratorState(character);            
            }
        }

        return character;
    }

    private void updateIteratorState(Character character) {
        if (isQuote(character)) {
            insideQuotes = !insideQuotes;
        } else if (isOpeningParenthesis(character)) {
            parenthesesLevel += 1;
        } else if (isClosingParenthesis(character)) {
            parenthesesLevel -= 1;
        } else if (isOpeningSquareBracket(character)) {
            squareBracketLevel += 1;
        } else if (isClosingSquareBracket(character)) {
            squareBracketLevel -= 1;
        } else if (isOpeningCurlyBracket(character)) {
            curlyBracketLevel += 1;
        } else if (isClosingCurlyBracket(character)) {
            curlyBracketLevel -= 1;
        }
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    public boolean insideQuotes() {
        return insideQuotes;
    }
    
    public boolean insideParentheses() {
        return (parenthesesLevel > 0);
    }
    
    public boolean insideSquareBrackets() {
        return (squareBracketLevel > 0);
    }

    public boolean insideCurlyBrackets() {
        return (curlyBracketLevel > 0);
    }
}
