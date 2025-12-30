package sweetRush.model.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void testScoreCreation() {
        Score score = new Score();
        assertEquals(0, score.getPoints());
    }

    @Test
    void testAddPoints() {
        Score score = new Score();
        score.addPoints(10);
        assertEquals(10, score.getPoints());
        score.addPoints(5);
        assertEquals(15, score.getPoints());
    }

    @Test
    void testReset() {
        Score score = new Score();
        score.addPoints(20);
        score.reset();
        assertEquals(0, score.getPoints());
    }
}
