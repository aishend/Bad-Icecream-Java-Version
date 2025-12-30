package sweetRush.model.menu;

public class WinMenu extends Menu {
    private final int score;
    private final int timeBonus;
    private final long remainingTime;

    public WinMenu(int score, int timeBonus, long remainingTime) {
        super("You Win! Score: " + score, "Next Level", "Back to Main Menu");
        this.score = score;
        this.timeBonus = timeBonus;
        this.remainingTime = remainingTime;
    }

    public int getScore() {
        return score;
    }

    public int getTimeBonus() {
        return timeBonus;
    }

    public long getRemainingTime() {
        return remainingTime;
    }
}