package sweetRush.model.game.arena;

import sweetRush.model.game.elements.candies.Blue;
import sweetRush.model.game.elements.candies.Green;
import sweetRush.model.game.elements.candies.Red;
import sweetRush.model.game.elements.candies.Yellow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CandyFactoryTest {

    private final CandyFactory factory = new CandyFactory();

    @Test
    public void testCanCreate() {
        assertTrue(factory.canCreate('B'));
        assertTrue(factory.canCreate('G'));
        assertTrue(factory.canCreate('R'));
        assertTrue(factory.canCreate('Y'));
        assertTrue(factory.canCreate('C'));
        assertFalse(factory.canCreate('X'));
    }

    @Test
    public void testCreateBlue() {
        var candy = factory.create('B', 1, 2);
        assertNotNull(candy);
        assertTrue(candy instanceof Blue);
        assertEquals(1, candy.getPosition().getX());
        assertEquals(2, candy.getPosition().getY());
    }

    @Test
    public void testCreateGreen() {
        var candy = factory.create('G', 3, 4);
        assertNotNull(candy);
        assertTrue(candy instanceof Green);
    }

    @Test
    public void testCreateRed() {
        var candy = factory.create('R', 5, 6);
        assertNotNull(candy);
        assertTrue(candy instanceof Red);
    }

    @Test
    public void testCreateYellow() {
        var candy = factory.create('Y', 7, 8);
        assertNotNull(candy);
        assertTrue(candy instanceof Yellow);
    }

    @Test
    public void testCreateDefault() {
        var candy = factory.create('C', 9, 10);
        assertNotNull(candy);
        assertTrue(candy instanceof Blue); // default is Blue
    }

    @Test
    public void testCreateInvalid() {
        var candy = factory.create('Z', 0, 0);
        assertNull(candy);
    }
}
