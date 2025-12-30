package sweetRush.model.game;

public class Score {
    private int points;

    public Score() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void reset() {
        this.points = 0;
    }
}