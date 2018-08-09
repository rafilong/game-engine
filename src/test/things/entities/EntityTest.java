package test.things.entities;

import com.rafilong.things.entities.Entity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {
    private Entity a, b;

    @Before
    public void setUp() {
        a = new Entity( "test", 3, 2, 4);
        b = new Entity( "test", 3, 2, 4);
    }

    @Test
    public void attack() {
        a.attack(b);
        assertEquals(3, b.getHealth(), 0.05);
    }

    @Test
    public void takeDamage() {
        a.takeDamage(4);
        assertEquals(2, a.getHealth(), 0.05);
    }

    @Test
    public void takeTrueDamage() {
        a.takeTrueDamage(4);
        assertEquals(0, a.getHealth(), 0.05);
    }

    @Test
    public void isAlive_true() {
        assertTrue(a.isAlive());
    }

    @Test
    public void isAlive_false() {
        a.takeTrueDamage(5);
        assertFalse(a.isAlive());
    }
}
