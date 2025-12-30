package sweetRush.controller;

import sweetRush.controller.game.WallController;
import sweetRush.model.Direction;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WallControllerTest {
    private WallController controller;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        controller = new WallController(arena);
    }

    @Test
    void testCreateWall() {
        Position front = new Position(5, 5);
        controller.createOrDestroyWall(front, Direction.RIGHT);
        assertTrue(arena.isMarshmallowWall(new Position(5, 5)));
        assertTrue(arena.isMarshmallowWall(new Position(6, 5)));
    }

    @Test
    void testDestroyWall() {
        Position front = new Position(5, 5);
        controller.createOrDestroyWall(front, Direction.RIGHT);
        assertTrue(arena.isMarshmallowWall(new Position(5, 5)));

        controller.createOrDestroyWall(front, Direction.RIGHT);
        assertFalse(arena.isMarshmallowWall(new Position(5, 5)));
    }


    @Test
    void testCreateWallEquivalence() {

        Position front = new Position(5, 5);
        controller.createOrDestroyWall(front, Direction.RIGHT);
        assertTrue(arena.isMarshmallowWall(new Position(5, 5)));

        controller.createOrDestroyWall(front, Direction.RIGHT);
        assertFalse(arena.isMarshmallowWall(new Position(5, 5)));
    }

    @Test
    void testCreateWallBoundary() {

        Position front = new Position(9, 5);
        controller.createOrDestroyWall(front, Direction.RIGHT);

        assertTrue(arena.isMarshmallowWall(new Position(9, 5)));
        assertFalse(arena.isMarshmallowWall(new Position(10, 5)));
    }
}
