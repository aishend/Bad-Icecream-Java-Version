package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.menu.PauseMenu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PauseMenuControllerTest {
    private PauseMenuController controller;
    private PauseMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = new PauseMenu();
        controller = new PauseMenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testSelectResume() throws IOException {
        controller.handleSelect(game);
        verify(game).setState(any());
    }

    @Test
    void testSelectRestart() throws IOException {
        menu.nextEntry();
        when(game.getCurrentLevel()).thenReturn(1);
        when(game.getNumberOfPlayers()).thenReturn(1);
        controller.handleSelect(game);
        verify(game).setCurrentWave(1);
        verify(game).setState(any(GameState.class));
    }

    @Test
    void testSelectBackToLevels() throws IOException {
        menu.nextEntry();
        menu.nextEntry();
        controller.handleSelect(game);
        verify(game).setState(any(MenuState.class));
    }
}
