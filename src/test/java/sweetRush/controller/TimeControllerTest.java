package sweetRush.controller;

import sweetRush.model.game.Timer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TimeControllerTest {

    @Test
    void testStartTimer() {
        Timer timer = mock(Timer.class);
        TimeController controller = new TimeController(timer);
        controller.startTimer();
        verify(timer).start();
    }

    @Test
    void testStopTimer() {
        Timer timer = mock(Timer.class);
        TimeController controller = new TimeController(timer);
        controller.stopTimer();
        verify(timer).stop();
    }

    @Test
    void testIsTimeUp() {
        Timer timer = mock(Timer.class);
        when(timer.isFinished()).thenReturn(true);
        TimeController controller = new TimeController(timer);
        assertTrue(controller.isTimeUp());
        verify(timer).isFinished();
    }

    @Test
    void testGetRemainingTime() {
        Timer timer = mock(Timer.class);
        when(timer.getRemainingTime()).thenReturn(1000L);
        TimeController controller = new TimeController(timer);
        assertEquals(1000L, controller.getRemainingTime());
        verify(timer).getRemainingTime();
    }

    @Test
    void testGetTimer() {
        Timer timer = mock(Timer.class);
        TimeController controller = new TimeController(timer);
        assertEquals(timer, controller.getTimer());
    }
}
