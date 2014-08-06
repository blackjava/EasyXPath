package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class SingleTypeTest {

    @Test
    public void literal_is_recognized() {
        assertTrue(SingleType.isSingleType("xs:String"));
    }

    @Test
    public void literal_with_optional_empty_sequence_is_recognized() {
        assertTrue(SingleType.isSingleType("xs:String?"));
    }
    
    @Test
    public void empty_type_name_is_not_recognized() {
        assertFalse(SingleType.isSingleType(""));
    }

    @Test
    public void invalid_type_name_is_not_recognized() {
        assertFalse(SingleType.isSingleType("xs String"));
    }
}