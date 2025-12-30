package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelsMenuTest {

    @Test
    void testLevelsMenuCreation() {
        LevelsMenu menu = new LevelsMenu();
        assertEquals("Levels", menu.getTitle());
        assertTrue(menu.getNumberEntries() > 1);
        assertTrue(menu.getEntry(menu.getNumberEntries() - 1).equals("Back to Main Menu"));
    }
}
