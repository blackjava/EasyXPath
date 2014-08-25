package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class CastExpressionTest {

    @Test
    public void numeric_literal_is_recognized() {
        assertTrue(CastExpression.isCastExpression("1"));
    }

    @Test
    public void context_node_is_recognized() {
        assertTrue(CastExpression.isCastExpression("."));
    }
    
    @Test
    public void node_name_is_recognized() {
        assertTrue(CastExpression.isCastExpression("node"));
    }
    
    @Test
    public void node_name_cast_to_mandatory_type_is_recognized() {
        assertTrue(CastExpression.isCastExpression("node cast as xs:String"));
    }
    
    @Test
    public void node_name_cast_to_optional_type_is_recognized() {
        assertTrue(CastExpression.isCastExpression("node cast as xs:String?"));
    }

    @Test
    public void node_name_cast_to_unspecified_type_is_not_recognized() {
        assertFalse(CastExpression.isCastExpression("node cast as "));
    }
}