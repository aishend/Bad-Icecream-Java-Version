package sweetRush.model.game.arena;

import sweetRush.model.game.elements.monsters.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterFactoryTest {

    private final MonsterFactory factory = new MonsterFactory();

    @Test
    public void testCanCreate() {
        assertTrue(factory.canCreate('X'));
        assertTrue(factory.canCreate('T'));
        assertTrue(factory.canCreate('Z'));
        assertTrue(factory.canCreate('W'));
        assertFalse(factory.canCreate('M'));
    }

    @Test
    public void testCreate1() {
        var monster = factory.create('X', 1, 2);
        assertNotNull(monster);
        assertTrue(monster instanceof Monster1);
        assertEquals(1, monster.getPosition().getX());
        assertEquals(2, monster.getPosition().getY());
    }

    @Test
    public void testCreate2() {
        var monster = factory.create('T', 3, 4);
        assertNotNull(monster);
        assertTrue(monster instanceof Monster2);
    }

    @Test
    public void testCreate3() {
        var monster = factory.create('Z', 5, 6);
        assertNotNull(monster);
        assertTrue(monster instanceof Monster3);
    }

    @Test
    public void testCreate4() {
        var monster = factory.create('W', 7, 8);
        assertNotNull(monster);
        assertTrue(monster instanceof Monster4);
    }

    @Test
    public void testCreateInvalid() {
        var monster = factory.create('M', 0, 0);
        assertNull(monster);
    }
}
