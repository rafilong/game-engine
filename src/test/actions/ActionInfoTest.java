package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionInfo;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionInfoTest {
    private Action action;
    private Player player;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        action = new ActionInfo(player);
    }

    @Test
    public void execute_valid() {
        assertEquals("Level: 1", action.execute("").get(0));
        assertEquals("Gold: 0", action.execute("").get(1));
        assertEquals("Health: 500.0/500.0", action.execute("").get(2));
        assertEquals("Attack: 100.0", action.execute("").get(3));
        assertEquals("Defense: 10.0", action.execute("").get(4));
    }
}
