package xml.xpath.expression;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTypeTest {
    @Test
    public void plain_item_is_recognized(){
        assertTrue(ItemType.isItemType("item()"));
    }
    
    @Test
    public void parenthesized_item_is_recognized(){
        assertTrue(ItemType.isItemType("(item())"));
    }
    
    @Test
    public void item_with_only_one_parenthesis_is_not_recognized(){
        assertFalse(ItemType.isItemType("(item()"));
    }

    @Test
    public void anynodetest_is_recognized(){
        assertTrue(ItemType.isItemType("node()"));
    }

    @Test
    public void texttest_is_recognized(){
        assertTrue(ItemType.isItemType("text()"));
    }

    @Test
    public void pitest_is_recognized(){
        assertTrue(ItemType.isItemType("processing-instruction()"));
    }

    @Test
    public void commenttest_is_recognized(){
        assertTrue(ItemType.isItemType("comment()"));
    }

    @Test
    public void namespacenodetest_is_recognized(){
        assertTrue(ItemType.isItemType("namespace-node()"));
    }

    @Test
    public void documenttest_is_recognized(){
        assertTrue(ItemType.isItemType("document-node()"));
    }
}