package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.menu.HelpMenu;
import sweetRush.model.menu.Menu;
import sweetRush.model.menu.MainMenu;
import sweetRush.states.MenuState;

import java.io.IOException;

public class HelpMenuController extends MenuController {
    public HelpMenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                ((HelpMenu) getModel()).scrollUp();
                break;
            case DOWN:
                ((HelpMenu) getModel()).scrollDown();
                break;
            case SELECT:
                handleSelect(game);
                break;
        }
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        String selected = getModel().getSelectedEntry();
        if (selected.equals("Back to Main Menu")) {
            game.setState(new MenuState(new MainMenu()));
        }
    }
}
