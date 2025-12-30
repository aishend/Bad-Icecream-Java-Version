package sweetRush.states;

import sweetRush.model.game.arena.Arena;
import sweetRush.controller.Controller;
import sweetRush.controller.game.ArenaController;
import sweetRush.viewer.Viewer;
import sweetRush.viewer.game.GameViewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    @Test
    public void testGameState() {
        Arena arena = new Arena(10, 10);
        GameState state = new GameState(arena);

        assertEquals(arena, state.getModel());

        Controller controller = state.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof ArenaController);

        Viewer viewer = state.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);
    }
}
