package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionDrop;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionDropTest {
    private Action action;
    private Player player;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        action = new ActionDrop(player);
    }

    @Test
    public void execute_empty() {
        assertEquals("I can't drop ", action.execute("").get(0));
        assertTrue(player.getItems().contains("burrito"));
        assertFalse(player.getLocation().getItems().contains("burrito"));
    }

    @Test
    public void execute_valid() {
        action.execute("burrito");
        assertFalse(player.getItems().contains("burrito"));
        assertTrue(player.getLocation().getItems().contains("burrito"));
    }

    @Test
    public void execute_invalid() {
        assertEquals("I can't drop CS126", action.execute("CS126").get(0));
        assertTrue(player.getItems().contains("burrito"));
        assertFalse(player.getLocation().getItems().contains("burrito"));
    }
}
