package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class VarRefTest {
    @Test
    public void variable_with_no_namespace_is_recognized() {
        assertTrue(VarRef.isVarRef("$name"));
    }
    
    @Test
    public void variable_with_namespace_is_recognized() {
        assertTrue(VarRef.isVarRef("$namespace:name"));
    }
    
    @Test
    public void name_without_prefix_is_not_recognized() {
        assertFalse(VarRef.isVarRef("name"));
    }

    @Test
    public void prefix_without_name_is_not_recognized() {
        assertFalse(VarRef.isVarRef("$"));
    }
}
