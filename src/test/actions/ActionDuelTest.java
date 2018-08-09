package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionDuel;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionDuelTest {
    private Action action;

    @Before
    public void setUp() {
        Player player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        action = new ActionDuel(player);
    }

    @Test
    public void execute_invalid() {
        assertEquals("I can't duel that monster", action.execute("big scary boi").get(0));
    }
}
