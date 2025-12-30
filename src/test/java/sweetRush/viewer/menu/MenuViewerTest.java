package sweetRush.viewer.menu;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuViewerTest {
    private MenuViewer viewer;
    private MainMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new MainMenu();
        viewer = new MenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDraw() throws IOException {
        viewer.draw(gui);
        verify(gui).clear();
        verify(gui).refresh();
        verify(gui).drawText(new Position(25, 15), "SweetRush", "#FF69B4");

        verify(gui).drawText(new Position(26, 19), "> Play <", "#FFD700");
        verify(gui).drawText(new Position(28, 21), "Help", "#FFFFFF");
        verify(gui).drawText(new Position(28, 23), "Exit", "#FFFFFF");

        verify(gui).drawText(new Position(10, 38), "Use ARROWS to navigate, ENTER to select", "#888888");
    }
}
