package test.actions;

import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionQuit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionQuitTest {
    private Action action;

    @Before
    public void setUp() {
        action = new ActionQuit();
    }

    @Test
    public void execute_valid() {
        assertEquals("Leaving game.", action.execute("").get(0));
    }
}
