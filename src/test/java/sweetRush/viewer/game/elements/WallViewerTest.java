package sweetRush.viewer.game.elements;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class WallViewerTest {
    private Wall wall;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new Wall(10, 10);
        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawWall() {
        viewer.draw(wall, gui);
        verify(gui, times(1)).drawWall(wall.getPosition());
    }
}
