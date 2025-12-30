package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.menu.WinMenu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WinMenuControllerTest {
    private WinMenuController controller;
    private WinMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = new WinMenu(100, 50, 30000L);
        controller = new WinMenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testSelectNextLevel() throws IOException {
        when(game.getCurrentLevel()).thenReturn(1);
        when(game.getNumberOfPlayers()).thenReturn(1);
        controller.handleSelect(game);
        verify(game).setCurrentLevel(2);
        verify(game).setCurrentWave(1);
        verify(game).setState(any(GameState.class));
    }

    @Test
    void testSelectBackToMain() throws IOException {
        menu.nextEntry();
        controller.handleSelect(game);
        verify(game).setState(any(MenuState.class));
    }
}
