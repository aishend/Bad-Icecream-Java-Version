package sweetRush.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {

    @Test
    public void testMainMenu() {
        MainMenu menu = new MainMenu();
        assertEquals("SweetRush", menu.title);
        assertEquals(3, menu.entries.size());
        assertEquals("Play", menu.entries.get(0));
        assertEquals("Help", menu.entries.get(1));
        assertEquals("Exit", menu.entries.get(2));
    }

    @Test
    public void testNextEntry() {
        MainMenu menu = new MainMenu();
        assertEquals(0, menu.currentEntry);
        menu.nextEntry();
        assertEquals(1, menu.currentEntry);
        menu.nextEntry();
        assertEquals(2, menu.currentEntry);
        menu.nextEntry();
        assertEquals(0, menu.currentEntry);
    }

    @Test
    public void testPreviousEntry() {
        MainMenu menu = new MainMenu();
        menu.previousEntry();
        assertEquals(2, menu.currentEntry);
    }

    @Test
    public void testIsSelected() {
        MainMenu menu = new MainMenu();
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
    }
}
