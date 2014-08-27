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
        boolean inQuotes = false;
        while (iterator.hasNext()) {
            character = iterator.next();

            if (isQuote(character)) {
                inQuotes = !inQuotes;
            }
            
            if (isDelimiter(character) && !inQuotes) {
                break;
            } else {
                builder.append(character);
            }
        }
        
        return builder.toString().trim();
    }

    private static boolean isQuote(Character character) {
        return (character.equals('\'') || character.equals('"'));
    }

    private boolean isDelimiter(Character character) {
        return delimiter.equals(character);
    }
}