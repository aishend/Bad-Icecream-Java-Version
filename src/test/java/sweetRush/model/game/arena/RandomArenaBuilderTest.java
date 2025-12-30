package sweetRush.model.game.arena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomArenaBuilderTest {

    @Test
    public void testCreateArena() {
        RandomArenaBuilder builder = new RandomArenaBuilder(10, 10);
        var arena = builder.createArena();
        assertNotNull(arena);
        assertEquals(10, arena.getWidth());
        assertEquals(10, arena.getHeight());
        assertNotNull(arena.getPlayer());
    }

    @Test
    public void testCreateArenaSmall() {
        RandomArenaBuilder builder = new RandomArenaBuilder(5, 5);
        var arena = builder.createArena();
        assertNotNull(arena);
        assertEquals(5, arena.getWidth());
        assertEquals(5, arena.getHeight());
    }
}
