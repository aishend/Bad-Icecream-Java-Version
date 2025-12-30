package sweetRush.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position pos;

    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Property
    void getRandomNeighbour(@ForAll int x, @ForAll int y) {
        Position pos = new Position(x, y);
        Position neighbour = pos.getRandomNeighbour();
        assertTrue(
            neighbour.equals(pos.getUp()) ||
            neighbour.equals(pos.getDown()) ||
            neighbour.equals(pos.getLeft()) ||
            neighbour.equals(pos.getRight())
        );
    }

    @Test
    void testGetters() {
        Position pos = new Position(5, 10);
        assertEquals(5, pos.getX());
        assertEquals(10, pos.getY());
    }

    @Test
    void testEquals() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        Position pos3 = new Position(2, 2);
        assertEquals(pos1, pos2);
        assertNotEquals(pos1, pos3);
        assertNotEquals(pos1, null);
        assertNotEquals(pos1, "not a position");
    }

    @Test
    void testHashCode() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        assertEquals(pos1.hashCode(), pos2.hashCode());
    }
}
