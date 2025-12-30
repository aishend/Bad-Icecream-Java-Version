package sweetRush.model.game.elements.candies;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreenTest {

    @Test
    void testGreenCreation() {
        Green green = new Green(5, 5);
        assertEquals(new Position(5, 5), green.getPosition());
        assertEquals(20, green.getPoints());
        assertEquals("green", green.getType());
        assertFalse(green.isCollected());
    }

    @Test
    void testGreenCollect() {
        Green green = new Green(5, 5);
        green.collect();
        assertTrue(green.isCollected());
    }
}
