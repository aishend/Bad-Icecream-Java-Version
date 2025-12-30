package sweetRush.model.game.elements.candies;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlueTest {

    @Test
    void testBlueCreation() {
        Blue blue = new Blue(5, 5);
        assertEquals(new Position(5, 5), blue.getPosition());
        assertEquals(10, blue.getPoints());
        assertEquals("blue", blue.getType());
        assertFalse(blue.isCollected());
    }

    @Test
    void testBlueCollect() {
        Blue blue = new Blue(5, 5);
        blue.collect();
        assertTrue(blue.isCollected());
    }
}
