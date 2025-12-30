package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.Timer;

public class TimerViewer {
    private Timer timer;

    public TimerViewer(Timer timer) {
        this.timer = timer;
    }

    public void draw(GUI gui) {
        long remaining = timer.getRemainingTime() / 1000;
        gui.drawText(new Position(45, 0), "TIME: " + remaining, "#FFFFFF");
    }
}