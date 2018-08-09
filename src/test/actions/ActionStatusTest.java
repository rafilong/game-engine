package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionStatus;
import com.rafilong.things.entities.Entity;
import com.rafilong.things.entities.Monster;
import com.rafilong.things.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionStatusTest {
    private Action action;
    private Player player;
    private Monster monster;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        monster = new Monster(new Entity( "test", 3, 2, 4));

        action = new ActionStatus(player, monster);
    }

    @Test
    public void execute_empty() {
        player.attack(monster);

        assertEquals("Player:  ####################", action.execute("").get(0));
        assertEquals("Monster: ____________________", action.execute("").get(1));
    }

    @Test
    public void execute_valid() {
        assertEquals("Player:  ####################", action.execute("").get(0));
        assertEquals("Monster: ####################", action.execute("").get(1));
    }
}
