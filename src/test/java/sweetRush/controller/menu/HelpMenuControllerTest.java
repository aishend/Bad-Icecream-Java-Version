package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.menu.HelpMenu;
import sweetRush.model.menu.MainMenu;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HelpMenuControllerTest {
    private HelpMenuController controller;
    private HelpMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = new HelpMenu();
        controller = new HelpMenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testScrollUp() throws IOException {
        int initial = menu.getScrollIndex();
        controller.step(game, GUI.ACTION.UP, 1000);
        assertEquals(Math.max(0, initial - 1), menu.getScrollIndex());
    }

    @Test
    void testScrollDown() throws IOException {
        int initial = menu.getScrollIndex();
        controller.step(game, GUI.ACTION.DOWN, 1000);
        assertEquals(Math.min(menu.getInstructions().size() - 1, initial + 1), menu.getScrollIndex());
    }

    @Test
    void testSelect() throws IOException {
        controller.step(game, GUI.ACTION.SELECT, 1000);
        verify(game).setState(any(MenuState.class));
    }
}
