package test.things.objects;

import com.rafilong.things.objects.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeaponTest {
    private Weapon sword;

    @Before
    public void setUp() {
        sword = new Weapon("BF Sword", 4, 10);
    }

    @Test
    public void toString_default() {
        assertEquals("BF Sword (4)", sword.toString());
    }

    @Test
    public void getDamage_default() {
        assertEquals(10, sword.getDamage());
    }

    @Test
    public void getPrice_default() {
        assertEquals(4, sword.getPrice());
    }
}
