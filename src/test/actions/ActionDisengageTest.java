package test.actions;

import com.rafilong.modes.Action;
import com.rafilong.modes.game.actions.ActionDisengage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionDisengageTest {
    private Action action;

    @Before
    public void setUp() {
        action = new ActionDisengage();
    }

    @Test
    public void execute_valid() {
        assertEquals("Run away!", action.execute("").get(0));
    }
}
