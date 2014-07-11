package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ForwardStepTest {
    
    public ForwardStepTest() {
    }

    @Test
    public void child_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("child::node"));
    }
    
    @Test
    public void descendant_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("descendant::node"));
    }

    @Test
    public void attribute_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("attribute::node"));
    }

    @Test
    public void self_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("self::node"));
    }

    @Test
    public void descendant_or_self_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("descendant-or-self::node"));
    }

    @Test
    public void following_sibling_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("following-sibling::node"));
    }

    @Test
    public void following_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("following::node"));
    }

    @Test
    public void namespace_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("namespace::node"));
    }

    @Test
    public void abbreviated_attribute_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("@node"));
    }

    @Test
    public void abbreviated_element_step_is_recognized() {
        assertTrue(ForwardStep.isForwardStep("node"));
    }

    @Test
    public void invalid_axis_is_not_recognized() {
        assertFalse(ForwardStep.isForwardStep("parent::node"));
    }

    @Test
    public void invalid_abbreviation_is_not_recognized() {
        assertFalse(ForwardStep.isForwardStep("+node"));
    }
}
