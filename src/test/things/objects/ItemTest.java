package test.things.objects;

import com.rafilong.things.objects.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    private Item sword;

    @Before
    public void setUp() {
        sword = new Item("BF Sword", 10);
    }

    @Test
    public void toString_default() {
        assertEquals("BF Sword (10)", sword.toString());
    }

    @Test
    public void getPrice_default() {
        assertEquals(10, sword.getPrice());
    }
}
