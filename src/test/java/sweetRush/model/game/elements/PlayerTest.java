package sweetRush.model.game.elements;

import sweetRush.model.Direction;
import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerCreation() {
        Player player = new Player(5, 5);
        assertEquals(new Position(5, 5), player.getPosition());
        assertEquals(3, player.getLives());
        assertEquals(Direction.UP, player.getFacing());
    }

    @Test
    void testDecreaseLife() {
        Player player = new Player(5, 5);
        player.decreaseLife();
        assertEquals(2, player.getLives());
    }

    @Test
    void testSetFacing() {
        Player player = new Player(5, 5);
        player.setFacing(Direction.DOWN);
        assertEquals(Direction.DOWN, player.getFacing());
    }

    @Test
    void testLivesEquivalence() {
        Player player = new Player(5, 5);

        assertTrue(player.getLives() > 0);


        player.decreaseLife();
        player.decreaseLife();
        player.decreaseLife();
        assertEquals(0, player.getLives());
    }


    @Test
    void testLivesBoundary() {
        Player player = new Player(5, 5);
        assertEquals(3, player.getLives());


        for (int i = 0; i < 3; i++) {
            player.decreaseLife();
        }
        assertEquals(0, player.getLives());

        player.decreaseLife();
        assertEquals(-1, player.getLives());
    }

    @Test
    void testGetFacingPosition() {
        Player player = new Player(5, 5);
        assertEquals(new Position(5, 4), player.getFacingPosition());

        player.setFacing(Direction.DOWN);
        assertEquals(new Position(5, 6), player.getFacingPosition());

        player.setFacing(Direction.LEFT);
        assertEquals(new Position(4, 5), player.getFacingPosition());

        player.setFacing(Direction.RIGHT);
        assertEquals(new Position(6, 5), player.getFacingPosition());
    }
}
