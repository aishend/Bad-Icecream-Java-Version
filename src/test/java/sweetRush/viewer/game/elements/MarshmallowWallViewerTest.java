package sweetRush.viewer.game.elements;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.MarshmallowWall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class MarshmallowWallViewerTest {
    private MarshmallowWall wall;
    private MarshmallowWallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new MarshmallowWall(10, 10);
        viewer = new MarshmallowWallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawMarshmallowWall() {
        viewer.draw(wall, gui);
        verify(gui, times(1)).drawMarshmallowWall(wall.getPosition());
    }
}
