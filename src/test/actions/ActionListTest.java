package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionList;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionListTest {
    private Action action;
    private Player player;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        action = new ActionList(player);
    }

    @Test
    public void execute_empty() {
        player.drop("burrito");
        assertEquals("I am carrying nothing", action.execute("").get(0));
    }

    @Test
    public void execute_valid() {
        assertEquals("I am carrying burrito", action.execute("").get(0));
    }
}
