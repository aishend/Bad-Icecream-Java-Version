package sweetRush.viewer.game.elements.candies;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.candies.Candy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class CandyViewerTest {
    private Candy candy;
    private CandyViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        candy = Mockito.mock(Candy.class);
        viewer = new CandyViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawCandy() {
        when(candy.getType()).thenReturn("blue");
        when(candy.getPosition()).thenReturn(new sweetRush.model.Position(0, 0));
        viewer.draw(candy, gui);
        verify(gui, times(1)).drawCandy(new sweetRush.model.Position(0, 0), "#0000FF");
    }
}
