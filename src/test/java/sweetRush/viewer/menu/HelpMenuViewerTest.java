package sweetRush.viewer.menu;

import sweetRush.gui.GUI;
import sweetRush.model.menu.HelpMenu;
import sweetRush.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HelpMenuViewerTest {
    private HelpMenuViewer viewer;
    private HelpMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new HelpMenu();
        viewer = new HelpMenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDraw() throws IOException {
        viewer.draw(gui);
        verify(gui).clear();
        verify(gui).refresh();

        verify(gui).drawText(new Position(28, 5), "HELP", "#FF69B4");

        verify(gui).drawText(new Position(19, 8), "Welcome to SweetRush!", "#FFFFFF");
        verify(gui).drawText(new Position(25, 10), "OBJECTIVE:", "#FFD700");

        verify(gui).drawText(new Position(19, 35), "> Back to Main Menu <", "#FFD700");
    }
}
