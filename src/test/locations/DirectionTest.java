package test.locations;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {
    private Game g;

    @Before
    public void setUp() {
        // Default starting room has one item (coin) and one valid direction (east)
        g = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test");
    }

    @Test
    public void getName_default() {
        assertEquals("East", g.getWorld().getZone(0, 0).getDirections().get(0).getName());
    }

    @Test
    public void getZone_default() {
        assertEquals(g.getWorld().getZone(0, 1), g.getWorld().getZone(0, 0).getDirections().get(0).getZone());
    }
}
