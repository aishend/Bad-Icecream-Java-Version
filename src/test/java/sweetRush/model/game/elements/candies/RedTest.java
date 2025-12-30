package sweetRush.model.game.elements.candies;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RedTest {

    @Test
    void testRedCreation() {
        Red red = new Red(5, 5);
        assertEquals(new Position(5, 5), red.getPosition());
        assertEquals(30, red.getPoints());
        assertEquals("red", red.getType());
        assertFalse(red.isCollected());
    }

    @Test
    void testCollect() {
        Red red = new Red(5, 5);
        red.collect();
        assertTrue(red.isCollected());
    }

    @Test
    void testPoints() {
        Red red = new Red(5, 5);
        assertEquals(30, red.getPoints());
    }

    @Test
    void testType() {
        Red red = new Red(5, 5);
        assertEquals("red", red.getType());
    }
}
