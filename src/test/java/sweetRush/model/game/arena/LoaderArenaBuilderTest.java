package sweetRush.model.game.arena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoaderArenaBuilderTest {

    @Test
    void testCreateArena() throws Exception {
        LoaderArenaBuilder builder = new LoaderArenaBuilder(1);
        var arena = builder.createArena();
        assertNotNull(arena);
        assertTrue(arena.getWidth() > 0);
        assertTrue(arena.getHeight() > 0);
        assertNotNull(arena.getPlayer());
    }
}
