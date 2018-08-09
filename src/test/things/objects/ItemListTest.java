package test.things.objects;

import com.rafilong.things.objects.Item;
import com.rafilong.things.objects.ItemList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemListTest {
    private ItemList one;
    private ItemList two;
    private ItemList three;
    private ItemList empty;

    @Before
    public void setUp() {
        one = new ItemList();
        one.add(new Item("test"));

        two = new ItemList();
        two.add(new Item("hi"));
        two.add(new Item("there"));

        three = new ItemList();
        three.add(new Item("it"));
        three.add(new Item("is"));
        three.add(new Item("wednesday"));

        empty = new ItemList();
    }

    @Test
    public void get_exists() {
        assertTrue(two.get("hi").isPresent());
        assertEquals("hi", two.get("hi").get().getName());
    }

    @Test
    public void get_existsCase() {
        assertTrue(two.get("hI").isPresent());
        assertEquals("hi", two.get("hI").get().getName());
    }

    @Test
    public void get_dne() {
        assertFalse(two.get("mmm").isPresent());
    }

    @Test
    public void get_empty() {
        assertFalse(empty.get("hI").isPresent());
    }


    @Test
    public void contains_exists() {
        assertTrue(two.contains("hi"));
    }

    @Test
    public void contains_case() {
        assertTrue(two.contains("HI"));
    }

    @Test
    public void contains_dne() {
        assertFalse(two.contains("mmm"));
    }

    @Test
    public void contains_empty() {
        assertFalse(empty.contains("mmm"));
    }


    @Test
    public void list_one() {
        assertEquals("test (0)", one.toString());
    }

    @Test
    public void list_two() {
        assertEquals("hi (0) and there (0)", two.toString());
    }

    @Test
    public void list_three() {
        assertEquals("it (0), is (0), and wednesday (0)", three.toString());
    }

    @Test
    public void list_empty() {
        assertEquals("nothing", empty.toString());
    }
}