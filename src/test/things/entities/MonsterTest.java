package test.things.entities;

import com.rafilong.things.entities.Entity;
import com.rafilong.things.entities.Monster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonsterTest {
    private Monster a;

    @Before
    public void setUp() {
        a = new Monster(new Entity( "test", 3, 2, 4));
    }

    @Test
    public void defeatExp() {
        assertEquals(130, a.defeatExp(), 0.05);
    }
}
