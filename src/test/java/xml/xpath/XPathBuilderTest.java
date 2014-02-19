package xml.xpath;

import i18n.ErrorCode;
import org.junit.Test;
import static org.junit.Assert.*;
import xml.xpath.expression.UnsupportedExpressionException;

public class XPathBuilderTest {
    private final XPathBuilder builder = new XPathBuilder();
    
    @Test
    public void parse_a_single_for_expression_fails_with_unsupported_expression_exception() {
        UnsupportedExpressionException exception = null;
        
        try {
            builder.compile("for $var in . return .");
        } catch (UnsupportedExpressionException e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertNotNull(exception.getErrorCode());
        assertEquals(ErrorCode.UNSUPPORTED_EXPRESSION_FOR, exception.getErrorCode());
    }

    @Test
    public void parse_a_single_let_expression_fails_with_unsupported_expression_exception() {
        UnsupportedExpressionException exception = null;
        
        try {
            builder.compile("let $var := . return .");
        } catch (UnsupportedExpressionException e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertNotNull(exception.getErrorCode());
        assertEquals(ErrorCode.UNSUPPORTED_EXPRESSION_LET, exception.getErrorCode());
    }

    @Test
    public void parse_a_single_quantified_expression_fails_with_unsupported_expression_exception() {
        UnsupportedExpressionException exception = null;
        
        try {
            builder.compile("some $var in . satisfies .");
        } catch (UnsupportedExpressionException e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertNotNull(exception.getErrorCode());
        assertEquals(ErrorCode.UNSUPPORTED_EXPRESSION_QUANTIFIED, exception.getErrorCode());
    }

    @Test
    public void parse_a_single_if_expression_fails_with_unsupported_expression_exception() {
        UnsupportedExpressionException exception = null;
        
        try {
            builder.compile("if (.) then . else .");
        } catch (UnsupportedExpressionException e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertNotNull(exception.getErrorCode());
        assertEquals(ErrorCode.UNSUPPORTED_EXPRESSION_IF, exception.getErrorCode());
    }

    @Test
    public void parse_a_single_or_expression_fails_with_unsupported_expression_exception() {
        UnsupportedExpressionException exception = null;
        
        try {
            builder.compile(". or .");
        } catch (UnsupportedExpressionException e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertNotNull(exception.getErrorCode());
        assertEquals(ErrorCode.UNSUPPORTED_EXPRESSION_OR, exception.getErrorCode());
    }
    
    @Test
    public void parse_an_invalid_expression_fails_with_unsupported_expression_exception() {
        UnsupportedExpressionException exception = null;
        
        try {
            builder.compile("unknown expression");
        } catch (UnsupportedExpressionException e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertNotNull(exception.getErrorCode());
        assertEquals(ErrorCode.UNSUPPORTED_EXPRESSION_OR, exception.getErrorCode());
    }
}
