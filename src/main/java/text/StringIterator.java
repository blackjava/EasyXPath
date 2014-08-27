package text;

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
            
            if (isQuote(character)) {
                insideQuotes = !insideQuotes;
            }
            
            if (character.equals('(')) {
                parenthesesLevel += 1;
            }

            if (character.equals(')')) {
                parenthesesLevel -= 1;
            }

            if (character.equals('[')) {
                squareBracketLevel += 1;
            }

            if (character.equals(']')) {
                squareBracketLevel -= 1;
            }            

            if (character.equals('{')) {
                curlyBracketLevel += 1;
            }

            if (character.equals('}')) {
                curlyBracketLevel -= 1;
            }            
        }

        return character;
    }

    private static boolean isQuote(Character character) {
        return (character.equals('\'') || character.equals('"'));
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
