package xml.xpath.nodetest;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommentTestTest {
    @Test
    public void empty_comment_test_is_recognized() {
        assertTrue(CommentTest.isCommentTest("comment()"));
    }

    @Test
    public void comment_test_with_content_is_not_recognized() {
        assertFalse(CommentTest.isCommentTest("comment(name)"));
    }
    
    @Test
    public void comment_test_without_parenthesis_is_not_recognized() {
        assertFalse(CommentTest.isCommentTest("comment"));
    }
    
    @Test
    public void function_is_not_recognized() {
        assertFalse(CommentTest.isCommentTest("function()"));
    }
}