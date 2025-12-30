package sweetRush.states;

import sweetRush.model.menu.MainMenu;
import sweetRush.model.menu.Menu;
import sweetRush.controller.Controller;
import sweetRush.controller.menu.MenuController;
import sweetRush.viewer.Viewer;
import sweetRush.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {

    @Test
    public void testMenuState() {
        Menu menu = new MainMenu();
        MenuState state = new MenuState(menu);

        assertEquals(menu, state.getModel());

        Controller controller = state.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof MenuController);

        Viewer viewer = state.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuViewer);
    }
}
