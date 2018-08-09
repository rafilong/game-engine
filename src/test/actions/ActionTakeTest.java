package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionTake;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTakeTest {
    private Action action;
    private Player player;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        action = new ActionTake(player);
    }

    @Test
    public void execute() {
        assertTrue(player.take("coin"));
        assertTrue(player.getItems().contains("coin"));
        assertFalse(player.getLocation().getItems().contains("coin"));
    }

    @Test
    public void take_invalid() {
        assertFalse(player.take("test"));
        assertFalse(player.getItems().contains("coin"));
        assertTrue(player.getLocation().getItems().contains("coin"));
    }

    @Test
    public void take_empty() {
        assertFalse(player.take(""));
        assertFalse(player.getItems().contains("coin"));
        assertTrue(player.getLocation().getItems().contains("coin"));
    }
}
