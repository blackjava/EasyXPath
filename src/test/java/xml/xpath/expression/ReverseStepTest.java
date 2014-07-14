package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseStepTest {

    @Test
    public void parent_step_is_recognized() {
        assertTrue(ReverseStep.isReverseStep("parent::node"));
    }
    
    @Test
    public void ancestor_step_is_recognized() {
        assertTrue(ReverseStep.isReverseStep("ancestor::node"));
    }

    @Test
    public void preceding_sibling_step_is_recognized() {
        assertTrue(ReverseStep.isReverseStep("preceding-sibling::node"));
    }

    @Test
    public void preceding_step_is_recognized() {
        assertTrue(ReverseStep.isReverseStep("preceding::node"));
    }

    @Test
    public void ancestor_or_self_step_is_recognized() {
        assertTrue(ReverseStep.isReverseStep("ancestor-or-self::node"));
    }

    @Test
    public void abbreviated_parent_step_is_recognized() {
        assertTrue(ReverseStep.isReverseStep(".."));
    }

    @Test
    public void abbreviated_parent_step__with_node_test_is_not_recognized() {
        assertFalse(ReverseStep.isReverseStep("..node"));
    }

    @Test
    public void invalid_axis_is_not_recognized() {
        assertFalse(ReverseStep.isReverseStep("child::node"));
    }

    @Test
    public void invalid_abbreviation_is_not_recognized() {
        assertFalse(ReverseStep.isReverseStep("++"));
    }
}
