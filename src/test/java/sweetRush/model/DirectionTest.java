package sweetRush.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testDirectionValues() {
        Direction[] directions = Direction.values();
        assertEquals(4, directions.length);
        assertTrue(java.util.Arrays.asList(directions).contains(Direction.UP));
        assertTrue(java.util.Arrays.asList(directions).contains(Direction.DOWN));
        assertTrue(java.util.Arrays.asList(directions).contains(Direction.LEFT));
        assertTrue(java.util.Arrays.asList(directions).contains(Direction.RIGHT));
    }
}
