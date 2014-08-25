package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class AxisStepTest {

    @Test
    public void forward_axis_step_is_recognized() {
        assertTrue(AxisStep.isAxisStep("child::node"));
    }

    @Test
    public void reverse_axis_step_is_recognized() {
        assertTrue(AxisStep.isAxisStep("parent::node"));
    }

    @Test
    public void abbreviated_axis_step_is_recognized() {
        assertTrue(AxisStep.isAxisStep("@node"));
    }
    
    @Test
    public void illegal_axis_step_is_not_recognized() {
        assertFalse(AxisStep.isAxisStep("illegal::node"));
    }

    @Test
    public void invalid_axis_step_is_not_recognized() {
        assertFalse(AxisStep.isAxisStep("..node"));
    }
}