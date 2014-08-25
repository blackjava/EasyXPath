package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class PredicateListTest {

    @Test
    public void empty_list_of_predicates_is_recognized() {
        assertTrue(PredicateList.isPredicateList(""));
    }

    @Test
    public void single_predicate_is_recognized() {
        assertTrue(PredicateList.isPredicateList("[]"));
    }

    @Test
    public void multiple_predicates_is_recognized() {
        assertTrue(PredicateList.isPredicateList("[][][]"));
    }
}