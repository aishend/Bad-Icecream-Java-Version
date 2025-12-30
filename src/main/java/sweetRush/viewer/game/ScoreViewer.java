package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.Score;

public class ScoreViewer {
    private Score score;

    public ScoreViewer(Score score) {
        this.score = score;
    }

    public void draw(GUI gui) {
        gui.drawText(new Position(1, 0), "SCORE: " + score.getPoints(), "#FFD700");
    }
}