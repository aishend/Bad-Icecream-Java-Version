package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.game.arena.LoaderArenaBuilder;
import sweetRush.model.menu.MainMenu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;

import java.io.IOException;
import sweetRush.model.menu.Menu;
public class GameOverMenuController extends MenuController {
    public GameOverMenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        String selected = getModel().getSelectedEntry();
        if (selected.equals("Restart")) {
            game.setCurrentWave(1);
            game.setState(new GameState(new LoaderArenaBuilder(game.getCurrentLevel(), 1, game.getNumberOfPlayers()).createArena()));
        } else if (selected.equals("Back to Main Menu")) {
            game.setState(new MenuState(new MainMenu()));
        }
    }
}
