package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScoreViewerTest {

    @Test
    void testDraw() throws IOException {
        Score score = new Score();
        score.addPoints(100);
        ScoreViewer viewer = new ScoreViewer(score);
        GUI gui = Mockito.mock(GUI.class);
        viewer.draw(gui);
        verify(gui).drawText(new Position(1, 0), "SCORE: 100", "#FFD700");
    }
}
