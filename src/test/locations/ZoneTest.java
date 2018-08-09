package test.locations;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZoneTest {
    private Game g;

    @Before
    public void setUp() {
        // Default starting room has one item (coin) and one valid direction (east)
        g = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test");
    }

    @Test
    public void getName_default() {
        assertEquals("abandoned town", g.getWorld().getZone(0, 0).getName());
    }

    @Test
    public void listDirections_default() {
        assertEquals("East, South", g.getWorld().getZone(0, 0).listDirections());
    }
}
