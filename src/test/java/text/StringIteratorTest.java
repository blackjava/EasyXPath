package text;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringIteratorTest {

    @Test
    public void null_string_does_not_have_next_token() {
        StringIterator iterator = new StringIterator(null);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void empty_string_does_not_have_next_token() {
        StringIterator iterator = new StringIterator("");
        assertFalse(iterator.hasNext());
    }

    @Test
    public void character_string_has_next_token() {
        StringIterator iterator = new StringIterator("token");
        assertTrue(iterator.hasNext());
    }
    
    @Test
    public void whitespace_only_string_does_not_have_next_token() {
        StringIterator iterator = new StringIterator(" \t\n\r");
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void continuous_text_is_returned_in_sequence() {
        StringIterator iterator = new StringIterator("token");
        
        assertEquals(Character.valueOf('t'), iterator.next());
        assertEquals(Character.valueOf('o'), iterator.next());
        assertEquals(Character.valueOf('k'), iterator.next());
        assertEquals(Character.valueOf('e'), iterator.next());
        assertEquals(Character.valueOf('n'), iterator.next());
        assertNull(iterator.next());
    }

    @Test
    public void leading_and_trailing_whitespace_is_ignored() {
        StringIterator iterator = new StringIterator("\t token\n\r");
        
        assertEquals(Character.valueOf('t'), iterator.next());
        assertEquals(Character.valueOf('o'), iterator.next());
        assertEquals(Character.valueOf('k'), iterator.next());
        assertEquals(Character.valueOf('e'), iterator.next());
        assertEquals(Character.valueOf('n'), iterator.next());
        assertNull(iterator.next());
    }

    @Test
    public void whitespace_in_content_is_preserved() {
        StringIterator iterator = new StringIterator("_ \t\n\r_");
        
        assertEquals(Character.valueOf('_'), iterator.next());
        assertEquals(Character.valueOf(' '), iterator.next());
        assertEquals(Character.valueOf('\t'), iterator.next());
        assertEquals(Character.valueOf('\n'), iterator.next());
        assertEquals(Character.valueOf('\r'), iterator.next());
        assertEquals(Character.valueOf('_'), iterator.next());
        assertNull(iterator.next());
    }
    
    @Test
    public void remove_throws_unsupported_operation_exception() {
        StringIterator iterator = new StringIterator("");
        
        UnsupportedOperationException exception = null;
        try {
            iterator.remove();
        } catch (UnsupportedOperationException uoe) {
            exception = uoe;
        }
        
        assertNotNull(exception);
    }

}