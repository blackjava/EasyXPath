package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContextItemExpressionTest {
    @Test
    public void context_item_is_recognized() {
        assertTrue(ContextItemExpression.isContextItemExpression("."));
    }
    
    @Test
    public void string_is_not_recognized() {
        assertFalse(ContextItemExpression.isContextItemExpression("name"));
    }
}
