package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinMenuTest {

    @Test
    void testWinMenuCreation() {
        WinMenu menu = new WinMenu(100, 50, 30000L);
        assertEquals("You Win! Score: 100", menu.getTitle());
        assertEquals(2, menu.getNumberEntries());
        assertEquals("Next Level", menu.getEntry(0));
        assertEquals("Back to Main Menu", menu.getEntry(1));
        assertEquals(100, menu.getScore());
        assertEquals(50, menu.getTimeBonus());
        assertEquals(30000L, menu.getRemainingTime());
    }
}
