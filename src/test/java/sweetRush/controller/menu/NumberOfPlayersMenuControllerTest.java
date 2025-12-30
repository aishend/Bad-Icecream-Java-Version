package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.menu.NumberOfPlayersMenu;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NumberOfPlayersMenuControllerTest {
    private NumberOfPlayersMenuController controller;
    private NumberOfPlayersMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = new NumberOfPlayersMenu();
        controller = new NumberOfPlayersMenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testSelect1Player() throws IOException {
        controller.handleSelect(game);
        verify(game).setNumberOfPlayers(1);
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void testSelect2Players() throws IOException {
        menu.nextEntry();
        controller.handleSelect(game);
        verify(game).setNumberOfPlayers(2);
        verify(game).setState(any(MenuState.class));
    }
}
