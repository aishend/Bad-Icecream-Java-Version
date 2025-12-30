package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.menu.LevelsMenu;
import sweetRush.model.menu.HelpMenu;
import sweetRush.states.MenuState;

import java.io.IOException;
import sweetRush.model.menu.Menu;
import sweetRush.model.menu.NumberOfPlayersMenu;

public class MainMenuController extends MenuController {
    public MainMenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        String selected = getModel().getSelectedEntry();
        switch (selected) {
            case "Exit" -> game.setState(null);
            case "Play" -> game.setState(new MenuState(new NumberOfPlayersMenu()));
            case "Help" -> game.setState(new MenuState(new HelpMenu()));
        }
    }
}