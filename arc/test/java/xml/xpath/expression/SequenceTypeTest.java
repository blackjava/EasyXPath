package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class SequenceTypeTest {

    @Test
    public void empty_sequence_is_recognized() {
        assertTrue(SequenceType.isSequenceType("empty-sequence()"));
    }

    @Test
    public void element_is_recognized() {
        assertTrue(SequenceType.isSequenceType("element"));
    }

    @Test
    public void literal_is_recognized() {
        assertTrue(SequenceType.isSequenceType("xs:String"));
    }

    @Test
    public void optional_element_is_recognized() {
        assertTrue(SequenceType.isSequenceType("element?"));
    }

    @Test
    public void zero_or_more_element_is_recognized() {
        assertTrue(SequenceType.isSequenceType("element*"));
    }

    @Test
    public void one_or_more_element_is_recognized() {
        assertTrue(SequenceType.isSequenceType("element+"));
    }
}