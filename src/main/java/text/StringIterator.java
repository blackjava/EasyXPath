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

    @Override
    public Character next() {
        Character character = null;

        if (hasNext()) {
            character = string.charAt(index++);
        }

        return character;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
