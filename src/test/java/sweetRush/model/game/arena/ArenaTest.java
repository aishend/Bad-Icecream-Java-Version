package sweetRush.model.game.arena;

import sweetRush.model.Position;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.monsters.Monster1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class ArenaTest {

    @Test
    void testIsInside() {
        Arena arena = new Arena(10, 10);
        assertTrue(arena.isInside(new Position(0, 0)));
        assertTrue(arena.isInside(new Position(9, 9)));
        assertFalse(arena.isInside(new Position(-1, 5)));
        assertFalse(arena.isInside(new Position(10, 5)));
        assertFalse(arena.isInside(new Position(5, -1)));
        assertFalse(arena.isInside(new Position(5, 10)));
    }

    @Test
    void testIsEmpty() {
        Arena arena = new Arena(10, 10);
        arena.setWalls(Arrays.asList(new Wall(5, 5)));
        arena.setMonsters(Arrays.asList(new Monster1(6, 6)));

        assertTrue(arena.isEmpty(new Position(0, 0)));
        assertFalse(arena.isEmpty(new Position(5, 5)));
        assertTrue(arena.isEmpty(new Position(6, 6)));
        assertFalse(arena.isEmpty(new Position(-1, 5)));
    }

    @Test
    void testHasWall() {
        Arena arena = new Arena(10, 10);
        arena.setWalls(Arrays.asList(new Wall(5, 5), new Wall(6, 6)));
        assertTrue(arena.hasWall(new Position(5, 5)));
        assertTrue(arena.hasWall(new Position(6, 6)));
        assertFalse(arena.hasWall(new Position(7, 7)));
    }

    @Test
    void testIsMonster() {
        Arena arena = new Arena(10, 10);
        arena.setMonsters(Arrays.asList(new Monster1(5, 5)));
        assertTrue(arena.isMonster(new Position(5, 5)));
        assertFalse(arena.isMonster(new Position(6, 6)));
    }

    @Test
    void testCollectCandy() {
        Arena arena = new Arena(10, 10);
        arena.setCandies(new java.util.ArrayList<>());

        arena.collectCandy(new Position(5, 5));
    }

    @Test
    void testIsCandy() {
        Arena arena = new Arena(10, 10);
        assertFalse(arena.isCandy(new Position(5, 5)));
    }

    @Test
    void testCreateMarshmallowWall() {
        Arena arena = new Arena(10, 10);
        arena.createMarshmallowWall(new Position(5, 5));
        assertTrue(arena.hasMarshmallow(new Position(5, 5)));
    }

    @Test
    void testDestroyMarshmallowWall() {
        Arena arena = new Arena(10, 10);
        arena.createMarshmallowWall(new Position(5, 5));
        arena.destroyMarshmallowWall(new Position(5, 5));
        assertFalse(arena.hasMarshmallow(new Position(5, 5)));
    }

    @Test
    void testIsInsideEquivalence() {
        Arena arena = new Arena(10, 10);

        assertTrue(arena.isInside(new Position(0, 0)));
        assertTrue(arena.isInside(new Position(5, 5)));
        assertTrue(arena.isInside(new Position(9, 9)));

        // Invalid partition: outside
        assertFalse(arena.isInside(new Position(-1, 5)));
        assertFalse(arena.isInside(new Position(10, 5)));
        assertFalse(arena.isInside(new Position(5, -1)));
        assertFalse(arena.isInside(new Position(5, 10)));
    }

    @Test
    void testIsInsideBoundary() {
        Arena arena = new Arena(10, 10);

        assertTrue(arena.isInside(new Position(0, 0)));
        assertTrue(arena.isInside(new Position(9, 9)));
        assertFalse(arena.isInside(new Position(-1, 0)));
        assertFalse(arena.isInside(new Position(0, -1)));
        assertFalse(arena.isInside(new Position(10, 9)));
        assertFalse(arena.isInside(new Position(9, 10)));
    }
}
