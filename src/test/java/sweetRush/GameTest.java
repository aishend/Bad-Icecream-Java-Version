package sweetRush;

import sweetRush.states.State;
import sweetRush.states.MenuState;
import sweetRush.model.menu.MainMenu;
import sweetRush.gui.GUI;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    public void testGameConstructor() throws Exception {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        assertNotNull(game.getState());
        assertTrue(game.getState() instanceof MenuState);
        assertEquals(1, game.getCurrentLevel());
    }

    @Test
    public void testSetState() throws Exception {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        State newState = new MenuState(new MainMenu());
        game.setState(newState);
        assertEquals(newState, game.getState());
    }

    @Test
    public void testGetCurrentLevel() throws Exception {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        assertEquals(1, game.getCurrentLevel());
    }

    @Test
    public void testSetCurrentLevel() throws Exception {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        game.setCurrentLevel(2);
        assertEquals(2, game.getCurrentLevel());
    }

    @Test
    public void testPreviousState() {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        State state = mock(State.class);
        game.setPreviousState(state);
        assertEquals(state, game.getPreviousState());
    }

    @Test
    public void testCurrentWave() {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        game.setCurrentWave(5);
        assertEquals(5, game.getCurrentWave());
    }

    @Test
    public void testNumberOfPlayers() {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        game.setNumberOfPlayers(2);
        assertEquals(2, game.getNumberOfPlayers());
    }

    @Test
    public void testStart() throws IOException {
        GUI gui = mock(GUI.class);
        Game game = new Game(gui);
        State state = mock(State.class);
        game.setState(state);

        doAnswer(invocation -> {
            Game g = invocation.getArgument(0);
            g.setState(null);
            return null;
        }).when(state).step(any(Game.class), any(GUI.class), anyLong());

        java.lang.reflect.Method method;
        try {
            method = Game.class.getDeclaredMethod("start");
            method.setAccessible(true);
            method.invoke(game);
        } catch (Exception e) {
            fail("Failed to invoke start method: " + e.getMessage());
        }

        verify(state, times(1)).step(any(Game.class), eq(gui), anyLong());
        verify(gui, times(1)).close();
    }
}
