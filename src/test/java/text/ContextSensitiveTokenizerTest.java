package text;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContextSensitiveTokenizerTest {
    @Test
    public void null_text_gives_no_tokens() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer(null, ',');
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void empty_text_gives_no_tokens() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("", ',');
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void whitespace_only_gives_no_tokens() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer(" \t\n\r", ',');
        assertNull(tokenizer.nextToken());
    }
    
    @Test
    public void single_token_is_not_broken() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("single token", ',');
        assertEquals("single token", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void whitespace_is_trimmed() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer(" single token \n\t\r", ',');
        assertEquals("single token", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }
    
    @Test
    public void two_tokens_are_split_correctly() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("first token, second token", ',');
        assertEquals("first token", tokenizer.nextToken());
        assertEquals("second token", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void empty_token_is_ignored() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("first token, ,second token", ',');
        assertEquals("first token", tokenizer.nextToken());
        assertEquals("second token", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void single_quoted_text_is_not_split() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("'quoted,token'", ',');
        assertEquals("'quoted,token'", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }
    
    @Test
    public void double_quoted_text_is_not_split() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("\"quoted,token\"", ',');
        assertEquals("\"quoted,token\"", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void escaped_single_quotes_do_not_affect_the_fragmentation() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("''quoted,token''", ',');
        assertEquals("''quoted", tokenizer.nextToken());
        assertEquals("token''", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void escaped_double_quotes_do_not_affect_the_fragmentation() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("\"\"quoted,token\"\"", ',');
        assertEquals("\"\"quoted", tokenizer.nextToken());
        assertEquals("token\"\"", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }
    
    @Test
    public void text_inside_parentheses_is_not_split() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("(parenthesized,token)", ',');
        assertEquals("(parenthesized,token)", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }

    @Test
    public void text_inside_nested_parenthesis_is_not_split() {
        ContextSensitiveTokenizer tokenizer = new ContextSensitiveTokenizer("((parenthesized),(token))", ',');
        assertEquals("((parenthesized),(token))", tokenizer.nextToken());
        assertNull(tokenizer.nextToken());
    }
}