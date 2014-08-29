package text;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilitiesTest {
    
    @Test
    public void null_is_recognized_as_empty_string() {
        assertTrue(StringUtilities.isEmpty(null));
    }
    
    @Test
    public void empty_string_is_recognized() {
        assertTrue(StringUtilities.isEmpty(""));
    }

    @Test
    public void string_with_content_is_not_recognized_as_empty_string() {
        assertFalse(StringUtilities.isEmpty("text"));
    }

}
