package sweetRush.model.game.elements.candies;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    @Test
    void testCandyCreation() {
        Candy candy = new Red(5, 5);
        assertEquals(new Position(5, 5), candy.getPosition());
        assertEquals(30, candy.getPoints());
        assertEquals("red", candy.getType());
        assertFalse(candy.isCollected());
    }

    @Test
    void testCollect() {
        Candy candy = new Red(5, 5);
        candy.collect();
        assertTrue(candy.isCollected());
    }
}
