package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.game.arena.LoaderArenaBuilder;
import sweetRush.model.menu.MainMenu;
import sweetRush.model.menu.Menu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;

import java.io.IOException;

public class WinMenuController extends MenuController {
    public WinMenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        String selected = getModel().getSelectedEntry();
        if (selected.equals("Next Level")) {
            int nextLevel = game.getCurrentLevel() + 1;
            if (nextLevel <= 5) {
                game.setCurrentLevel(nextLevel);
                game.setCurrentWave(1);
                game.setState(new GameState(new LoaderArenaBuilder(nextLevel, 1, game.getNumberOfPlayers()).createArena()));
            } else {
                game.setState(new MenuState(new MainMenu()));
            }
        } else if (selected.equals("Back to Main Menu")) {
            game.setState(new MenuState(new MainMenu()));
        }
    }
}
