package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class PredicateTest {

    @Test
    public void empty_brackets_are_recognized() {
        assertTrue(Predicate.isPredicate("[]"));
    }

}