package sweetRush.controller;

import sweetRush.model.game.Score;

public class ScoreController {
    private Score score;

    public ScoreController(Score score) {
        this.score = score;
    }

    public void addCandyPoints(int points) {
        score.addPoints(points);
    }

    public void addTimeBonus(long remainingTime) {
        int bonus = (int) (remainingTime / 1000) * 5; // 5 points per second left
        score.addPoints(bonus);
    }

    public Score getScore() {
        return score;
    }
}