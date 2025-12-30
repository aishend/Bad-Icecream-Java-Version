package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.menu.MainMenu;
import sweetRush.model.menu.LevelsMenu;
import sweetRush.model.menu.HelpMenu;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainMenuControllerTest {
    private MainMenuController controller;
    private MainMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = new MainMenu();
        controller = new MainMenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testSelectExit() throws IOException {
        menu.nextEntry();
        menu.nextEntry();
        controller.step(game, GUI.ACTION.SELECT, 1000);
        verify(game).setState(null);
    }

    @Test
    void testSelectPlay() throws IOException {
        controller.step(game, GUI.ACTION.SELECT, 1000);
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void testSelectHelp() throws IOException {
        menu.nextEntry();
        controller.step(game, GUI.ACTION.SELECT, 1000);
        verify(game).setState(any(MenuState.class));
    }
}
