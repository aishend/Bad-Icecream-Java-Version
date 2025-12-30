package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.menu.LevelsMenu;
import sweetRush.states.MenuState;

import java.io.IOException;
import sweetRush.model.menu.Menu;

public class NumberOfPlayersMenuController extends MenuController {
    public NumberOfPlayersMenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        String selected = getModel().getSelectedEntry();
        switch (selected) {
            case "1 Player" -> {
                game.setNumberOfPlayers(1);
                game.setState(new MenuState(new LevelsMenu()));
            }
            case "2 Players" -> {
                game.setNumberOfPlayers(2);
                game.setState(new MenuState(new LevelsMenu()));
            }
        }
    }
}