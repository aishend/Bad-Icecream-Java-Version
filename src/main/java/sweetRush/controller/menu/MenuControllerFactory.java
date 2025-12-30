package sweetRush.controller.menu;

import sweetRush.model.menu.*;

public class MenuControllerFactory {
    public static MenuController getController(Menu menu) {
        return switch (menu) {
            case MainMenu mainMenu -> new MainMenuController(menu);
            case LevelsMenu levelsMenu -> new LevelsMenuController(menu);
            case PauseMenu pauseMenu -> new PauseMenuController(menu);
            case GameOverMenu gameOverMenu -> new GameOverMenuController(menu);
            case WinMenu winMenu -> new WinMenuController(menu);
            case HelpMenu helpMenu -> new HelpMenuController(menu);
            case NumberOfPlayersMenu numberOfPlayersMenu -> new NumberOfPlayersMenuController(menu);
            case null, default -> throw new IllegalArgumentException("Unknown menu type");
        };
    }
}