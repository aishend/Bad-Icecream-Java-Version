package sweetRush.model.game.arena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArenaBuilderTest {

    @Test
    void testCreateArena() {
        ArenaBuilder builder = new RandomArenaBuilder(10, 10);
        Arena arena = builder.createArena();
        assertNotNull(arena);
        assertEquals(10, arena.getWidth());
        assertEquals(10, arena.getHeight());
        assertNotNull(arena.getTimer());
        assertNotNull(arena.getScore());
    }
}
