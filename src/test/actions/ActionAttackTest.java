package test.actions;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionAttack;
import com.rafilong.things.entities.Entity;
import com.rafilong.things.entities.Monster;
import com.rafilong.things.entities.Player;
import com.rafilong.things.objects.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionAttackTest {
    private Action action;
    private Player player;
    private Monster monster;

    @Before
    public void setUp() {
        player = Game.loadGame(GameEngine.SAVES_DIRECTORY, "test").getPlayer();
        monster = new Monster(new Entity( "test", 3, 2, 4));

        player.drop("burrito");
        player.getItems().add(new Weapon("burrito", 4, 9001));
        action = new ActionAttack(player, monster);
    }

    @Test
    public void execute_empty() {
        assertEquals("I viciously attack the test", action.execute("").get(0));
        assertEquals(-94, monster.getHealth(), 0.05);
    }

    @Test
    public void execute_valid() {
        assertEquals("I hit the test with my burrito", action.execute("burrito").get(0));
        assertEquals(-9095, monster.getHealth(), 0.05);
    }

    @Test
    public void execute_invalid() {
        assertEquals("I am not carrying pan", action.execute("pan").get(0));
    }
}
