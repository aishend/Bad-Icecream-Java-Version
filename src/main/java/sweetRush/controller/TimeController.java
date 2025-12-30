package sweetRush.controller;

import sweetRush.model.game.Timer;

public class TimeController {
    private Timer timer;

    public TimeController(Timer timer) {
        this.timer = timer;
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public boolean isTimeUp() {
        return timer.isFinished();
    }

    public long getRemainingTime() {
        return timer.getRemainingTime();
    }

    public Timer getTimer() {
        return timer;
    }
}