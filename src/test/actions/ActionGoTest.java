package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionGo;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionGoTest {
    private Action action;
    private Player player;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        action = new ActionGo(player);
    }

    @Test
    public void execute_empty() {
        assertEquals("I can't go ", action.execute("").get(0));
        assertEquals("abandoned town", player.getLocation().getName());
    }

    @Test
    public void execute_valid() {
        action.execute("east");
        assertEquals("abandoned town", player.getLocation().getName());
    }

    @Test
    public void execute_invalid() {
        action.execute("east");
        assertEquals("I can't go north", action.execute("north").get(0));
        assertEquals("abandoned town", player.getLocation().getName());
    }
}
