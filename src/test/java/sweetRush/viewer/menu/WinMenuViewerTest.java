package sweetRush.viewer.menu;

import sweetRush.gui.GUI;
import sweetRush.model.menu.WinMenu;
import sweetRush.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WinMenuViewerTest {
    private WinMenuViewer viewer;
    private WinMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new WinMenu(100, 50, 30000L);
        viewer = new WinMenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDraw() throws IOException {
        viewer.draw(gui);
        verify(gui).clear();
        verify(gui).refresh();

        verify(gui).drawText(new Position(20, 15), "You Win! Score: 100", "#FF69B4");

        verify(gui).drawText(new Position(23, 19), "> Next Level <", "#FFD700");
        verify(gui).drawText(new Position(21, 21), "Back to Main Menu", "#FFFFFF");

        verify(gui).drawText(new Position(10, 38), "Use ARROWS to navigate, ENTER to select", "#888888");

        verify(gui).drawText(new Position(13, 17), "Bonus Time +50 points (30 seconds)", "#00FF00");
    }
}
