package text;

/**
 * Divides a text into fragments based on a delimiter character.
 * When retrieving the next fragment, empty tokens are skipped.
 */
public class ContextSensitiveTokenizer {
    StringIterator iterator;
    private final Character delimiter;
    
    public ContextSensitiveTokenizer(String text, Character delimiter) {
        iterator = iterator = new StringIterator(text);
        this.delimiter = delimiter;
    }

    public String nextToken() {
        String token = null;

        while ((isEmpty(token)) && iterator.hasNext()) {
            token = getNextToken();
        }
        
        if (isEmpty(token)) {
            token = null;
        }
        
        return token;
    }

    private static boolean isEmpty(String token) {
        return (token == null) || token.isEmpty();
    }

    private String getNextToken() {
        StringBuilder builder = new StringBuilder();
        
        Character character;
        int  parenthesesLevels = 0;
        while (iterator.hasNext()) {
            character = iterator.next();

            if (character.equals('(')) {
                parenthesesLevels += 1;
            }
            
            if (isDelimiter(character) && !iterator.insideQuotes() && !(parenthesesLevels > 0)) {
                break;
            } else {
                builder.append(character);
            }
            
            if (character.equals(')')) {
                parenthesesLevels -= 1;
            }
        }
        
        return builder.toString().trim();
    }

    private boolean isDelimiter(Character character) {
        return delimiter.equals(character);
    }
}
