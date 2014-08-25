package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class OccurrenceIndicatorTest {

    @Test
    public void optional_occurrence_indicator_is_recognized() {
        assertTrue(OccurrenceIndicator.isOccurrenceIndicator("?"));
    }

    @Test
    public void zero_or_more_occurrence_indicator_is_recognized() {
        assertTrue(OccurrenceIndicator.isOccurrenceIndicator("*"));
    }

    @Test
    public void one_or_more_occurrence_indicator_is_recognized() {
        assertTrue(OccurrenceIndicator.isOccurrenceIndicator("+"));
    }

    @Test
    public void invalid_occurrence_indicator_is_not_recognized() {
        assertFalse(OccurrenceIndicator.isOccurrenceIndicator("."));
    }
}