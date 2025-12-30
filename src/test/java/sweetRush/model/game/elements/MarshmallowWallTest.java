package sweetRush.model.game.elements;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarshmallowWallTest {

    @Test
    void testMarshmallowWallCreation() {
        MarshmallowWall wall = new MarshmallowWall(5, 5);
        assertEquals(new Position(5, 5), wall.getPosition());
    }

    @Test
    void testMarshmallowWallPosition() {
        MarshmallowWall wall = new MarshmallowWall(10, 20);
        assertEquals(10, wall.getPosition().getX());
        assertEquals(20, wall.getPosition().getY());
    }
}
