package test.things.entities;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.things.entities.Entity;
import com.rafilong.things.entities.Player;
import com.rafilong.things.objects.Item;
import com.rafilong.things.objects.ItemList;
import com.rafilong.things.objects.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Game g;
    private Player p;
    private Entity e;

    @Before
    public void setUp() {
        // Default starting room has one item (coin) and one valid direction (east)
        g = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test");
        p = g.getPlayer();
        p.drop("burrito");
        e = new Entity( "test", 3, 2, 4);
    }

    @Test
    public void attack() {
        p.attack(e, new Weapon("sword", 4, 3));
        assertEquals(-97, e.getHealth(), 0.05);
    }

    @Test
    public void level() {
        assertEquals(1, p.getLevel());
        p.gainExp(50);
        assertEquals(1, p.getLevel());
        p.level();
        assertEquals(2, p.getLevel());
    }

    @Test
    public void getCurrentRoom_default() {
        assertEquals(g.getWorld().getZone(0, 0), p.getLocation());
    }

    @Test
    public void getItems_empty() {
        assertEquals(new ItemList(), p.getItems());
    }

    @Test
    public void getItems_one() {
        p.getItems().add(new Item("test"));
        assertEquals("test" , p.getItems().get(0).getName());
    }

    @Test
    public void go_valid() {
        assertTrue(p.go("east"));
        assertEquals(g.getWorld().getZone(0, 1), p.getLocation());
    }

    @Test
    public void go_invalid() {
        assertFalse(p.go("fast"));
        assertEquals(g.getWorld().getZone(0, 0), p.getLocation());
    }

    @Test
    public void go_empty() {
        assertFalse(p.go(""));
        assertEquals(g.getWorld().getZone(0, 0), p.getLocation());
    }


    @Test
    public void take_valid() {
        assertTrue(p.take("coin"));
        assertEquals("coin", p.getItems().get(0).getName());
        assertEquals(1, g.getWorld().getZone(0, 0).getItems().size());
    }

    @Test
    public void take_invalid() {
        assertFalse(p.take("test"));
        assertEquals(0, p.getItems().size());
        assertEquals("coin", g.getWorld().getZone(0, 0).getItems().get(0).getName());
    }

    @Test
    public void take_empty() {
        assertFalse(p.take(""));
        assertEquals(0, p.getItems().size());
        assertEquals("coin", g.getWorld().getZone(0, 0).getItems().get(0).getName());
    }

    @Test
    public void drop_valid() {
        p.getItems().add(new Item("test"));
        assertTrue(p.drop("test"));
        assertEquals(0, p.getItems().size());
        assertTrue(g.getWorld().getZone(0, 0).getItems().contains("test"));
    }

    @Test
    public void drop_invalid() {
        p.getItems().add(new Item("test"));
        assertFalse(p.drop("mmmm"));
        assertEquals(1, p.getItems().size());
    }

    @Test
    public void drop_empty() {
        p.getItems().add(new Item("test"));
        assertFalse(p.drop(""));
        assertEquals(1, p.getItems().size());
    }
}