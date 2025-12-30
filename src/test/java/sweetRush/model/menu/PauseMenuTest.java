package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PauseMenuTest {

    @Test
    void testPauseMenuCreation() {
        PauseMenu menu = new PauseMenu();
        assertEquals("Paused", menu.getTitle());
        assertEquals(3, menu.getNumberEntries());
        assertEquals("Resume", menu.getEntry(0));
        assertEquals("Restart", menu.getEntry(1));
        assertEquals("Back to Levels", menu.getEntry(2));
    }
}
