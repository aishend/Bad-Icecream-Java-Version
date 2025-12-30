package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.menu.LevelsMenu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LevelsMenuControllerTest {
    private LevelsMenuController controller;
    private LevelsMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = new LevelsMenu();
        controller = new LevelsMenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testSelectLevel() throws IOException {
        when(game.getNumberOfPlayers()).thenReturn(1);
        controller.handleSelect(game);
        verify(game).setCurrentLevel(1);
        verify(game).setCurrentWave(1);
        verify(game).setState(any(GameState.class));
    }

    @Test
    void testSelectBackToMain() throws IOException {
        menu.nextEntry();
        menu.nextEntry();
        menu.nextEntry();
        controller.handleSelect(game);
        verify(game).setState(any(MenuState.class));
    }
}
