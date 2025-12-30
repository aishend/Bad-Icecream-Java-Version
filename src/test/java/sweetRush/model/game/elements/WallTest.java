package sweetRush.model.game.elements;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void testWallCreation() {
        Wall wall = new Wall(5, 5);
        assertEquals(new Position(5, 5), wall.getPosition());
    }

    @Test
    void testWallPosition() {
        Wall wall = new Wall(10, 20);
        assertEquals(10, wall.getPosition().getX());
        assertEquals(20, wall.getPosition().getY());
    }
}
