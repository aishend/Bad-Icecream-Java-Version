package sweetRush.controller.menu;

import sweetRush.model.menu.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuControllerFactoryTest {

    @Test
    public void testGetControllerMainMenu() {
        Menu menu = new MainMenu();
        var controller = MenuControllerFactory.getController(menu);
        assertNotNull(controller);
        assertTrue(controller instanceof MainMenuController);
    }

    @Test
    public void testGetControllerLevelsMenu() {
        Menu menu = new LevelsMenu();
        var controller = MenuControllerFactory.getController(menu);
        assertNotNull(controller);
        assertTrue(controller instanceof LevelsMenuController);
    }

    @Test
    public void testGetControllerPauseMenu() {
        Menu menu = new PauseMenu();
        var controller = MenuControllerFactory.getController(menu);
        assertNotNull(controller);
        assertTrue(controller instanceof PauseMenuController);
    }

    @Test
    public void testGetControllerGameOverMenu() {
        Menu menu = new GameOverMenu();
        var controller = MenuControllerFactory.getController(menu);
        assertNotNull(controller);
        assertTrue(controller instanceof GameOverMenuController);
    }

    @Test
    public void testGetControllerWinMenu() {
        Menu menu = new WinMenu(0, 0, 0L);
        var controller = MenuControllerFactory.getController(menu);
        assertNotNull(controller);
        assertTrue(controller instanceof WinMenuController);
    }

    @Test
    public void testGetControllerHelpMenu() {
        Menu menu = new HelpMenu();
        var controller = MenuControllerFactory.getController(menu);
        assertNotNull(controller);
        assertTrue(controller instanceof HelpMenuController);
    }

    @Test
    public void testGetControllerUnknown() {
        assertThrows(IllegalArgumentException.class, () -> {
            MenuControllerFactory.getController(null);
        });
    }
}
