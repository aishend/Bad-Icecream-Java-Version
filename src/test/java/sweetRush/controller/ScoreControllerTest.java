package sweetRush.controller;

import sweetRush.model.game.Score;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreControllerTest {

    @Test
    void testAddCandyPoints() {
        Score score = new Score();
        ScoreController controller = new ScoreController(score);
        controller.addCandyPoints(10);
        assertEquals(10, score.getPoints());
    }

    @Test
    void testAddTimeBonus() {
        Score score = new Score();
        ScoreController controller = new ScoreController(score);
        controller.addTimeBonus(10000L); // 10 seconds * 5 = 50
        assertEquals(50, score.getPoints());
    }

    @Test
    void testGetScore() {
        Score score = new Score();
        ScoreController controller = new ScoreController(score);
        assertEquals(score, controller.getScore());
    }
}
