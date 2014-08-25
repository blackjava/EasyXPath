package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnaryExpressionTest {

    @Test
    public void unprefixed_number_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("3"));
    }
    
    @Test
    public void negative_prefixed_number_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("-3"));
    }

    @Test
    public void double_negative_prefixed_number_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("--3"));
    }
    
    @Test
    public void positive_prefixed_number_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("+3"));
    }

    @Test
    public void double_positive_prefixed_number_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("++3"));
    }

    @Test
    public void context_node_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("."));
    }

    @Test
    public void negative_prefixed_context_node_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("-."));
    }

    @Test
    public void positive_prefixed_context_node_is_recognized() {
        assertTrue(UnaryExpression.isUnaryExpression("+."));
    }
}