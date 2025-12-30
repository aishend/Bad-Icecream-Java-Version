package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.Timer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TimerViewerTest {

    @Test
    void testDraw() {
        Timer timer = Mockito.mock(Timer.class);
        when(timer.getRemainingTime()).thenReturn(5000L);

        TimerViewer viewer = new TimerViewer(timer);
        GUI gui = Mockito.mock(GUI.class);

        viewer.draw(gui);

        verify(gui).drawText(new Position(45, 0), "TIME: 5", "#FFFFFF");
    }
}

