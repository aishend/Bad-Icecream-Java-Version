package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelpMenuTest {

    @Test
    void testHelpMenuCreation() {
        HelpMenu menu = new HelpMenu();
        assertEquals("Help", menu.getTitle());
        assertEquals(1, menu.getNumberEntries());
        assertEquals("Back to Main Menu", menu.getEntry(0));
        assertNotNull(menu.getInstructions());
        assertTrue(menu.getInstructions().size() > 0);
    }

    @Test
    void testScroll() {
        HelpMenu menu = new HelpMenu();
        int initial = menu.getScrollIndex();
        menu.scrollDown();
        assertEquals(initial + 1, menu.getScrollIndex());
        menu.scrollUp();
        assertEquals(initial, menu.getScrollIndex());
    }
}
