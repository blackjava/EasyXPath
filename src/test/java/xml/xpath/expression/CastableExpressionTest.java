package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class CastableExpressionTest {

    @Test
    public void element_name_is_recognized() {
        assertTrue(CastableExpression.isCastableExpression("node"));
    }

    @Test
    public void cast_expression_is_recognized() {
        assertTrue(CastableExpression.isCastableExpression("node cast as xs:String"));
    }

    @Test
    public void casable_expression_with_element_name_is_recognized() {
        assertTrue(CastableExpression.isCastableExpression("node castable as xs:String"));
    }

    @Test
    public void casable_expression_with_element_name_and_optional_type_is_recognized() {
        assertTrue(CastableExpression.isCastableExpression("node castable as xs:String"));
    }
    
    @Test
    public void casable_expression_with_cast_of_element_name_is_recognized() {
        assertTrue(CastableExpression.isCastableExpression("node cast as xs:String castable as xs:String"));
    }

    @Test
    public void casable_expression_with_cast_of_element_name_and_optional_type_is_recognized() {
        assertTrue(CastableExpression.isCastableExpression("node cast as xs:String castable as xs:String?"));
    }
    
    @Test
    public void node_name_castable_to_unspecified_type_is_not_recognized() {
        assertFalse(CastableExpression.isCastableExpression("node castable as "));
    }
}