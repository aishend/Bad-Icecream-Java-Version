package sweetRush.model.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

    @Test
    void testTimerCreation() {
        Timer timer = new Timer(1000);
        assertFalse(timer.isRunning());
        assertEquals(1000, timer.getRemainingTime());
    }

    @Test
    void testStart() {
        Timer timer = new Timer(1000);
        timer.start();
        assertTrue(timer.isRunning());
    }

    @Test
    void testStop() {
        Timer timer = new Timer(1000);
        timer.start();
        timer.stop();
        assertFalse(timer.isRunning());
    }

    @Test
    void testReset() {
        Timer timer = new Timer(1000);
        timer.start();
        timer.reset();
        assertFalse(timer.isRunning());
    }

    @Test
    void testIsFinishedNotRunning() {
        Timer timer = new Timer(1000);
        assertFalse(timer.isFinished());
    }

    @Test
    void testGetElapsedTime() {
        Timer timer = new Timer(1000);
        timer.start();
        long elapsed = timer.getElapsedTime();
        assertTrue(elapsed >= 0);
    }
}
