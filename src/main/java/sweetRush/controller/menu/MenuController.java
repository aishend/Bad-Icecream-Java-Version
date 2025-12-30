package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.controller.Controller;
import sweetRush.gui.GUI;
import sweetRush.model.menu.Menu;


import java.io.IOException;

public abstract class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                handleSelect(game);
                break;
            case QUIT:
                game.setState(null);
                break;
        }
    }

    protected abstract void handleSelect(Game game) throws IOException;
}
