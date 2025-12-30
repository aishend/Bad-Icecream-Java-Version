package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameOverMenuTest {

    @Test
    void testGameOverMenuCreation() {
        GameOverMenu menu = new GameOverMenu();
        assertEquals("Game Over", menu.getTitle());
        assertEquals(2, menu.getNumberEntries());
        assertEquals("Restart", menu.getEntry(0));
        assertEquals("Back to Main Menu", menu.getEntry(1));
    }
}
