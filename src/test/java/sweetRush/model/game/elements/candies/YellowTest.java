package sweetRush.model.game.elements.candies;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YellowTest {

    @Test
    void testYellowCreation() {
        Yellow yellow = new Yellow(5, 5);
        assertEquals(new Position(5, 5), yellow.getPosition());
        assertEquals(40, yellow.getPoints());
        assertEquals("yellow", yellow.getType());
        assertFalse(yellow.isCollected());
    }

    @Test
    void testYellowCollect() {
        Yellow yellow = new Yellow(5, 5);
        yellow.collect();
        assertTrue(yellow.isCollected());
    }
}
