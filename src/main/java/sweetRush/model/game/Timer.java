package sweetRush.model.game;

public class Timer {
    private long startTime;
    private long duration;
    private boolean running;

    public Timer(long duration) {
        this.duration = duration;
        this.running = false;
    }

    public void start() {
        if (!running) {
            this.startTime = System.currentTimeMillis();
            this.running = true;
        }
    }

    public void stop() {
        this.running = false;
    }

    public boolean isFinished() {
        if (!running) return false;
        return getElapsedTime() >= duration;
    }

    public long getRemainingTime() {
        if (!running) return duration;
        long elapsed = getElapsedTime();
        return Math.max(0, duration - elapsed);
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public void reset() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }
}