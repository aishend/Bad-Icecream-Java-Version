package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void testMenuNavigation() {
        Menu menu = new MainMenu();
        assertEquals(0, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry());
        menu.previousEntry();
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    void testMenuEntries() {
        Menu menu = new MainMenu();
        assertEquals(3, menu.getNumberEntries());
        assertEquals("Play", menu.getEntry(0));
        assertFalse(menu.isSelected(1));
        assertTrue(menu.isSelected(0));
    }

    @Test
    void testMenuTitle() {
        Menu menu = new MainMenu();
        assertEquals("SweetRush", menu.getTitle());
    }
}
