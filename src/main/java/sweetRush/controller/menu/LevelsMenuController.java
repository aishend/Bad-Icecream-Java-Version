package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.game.arena.LoaderArenaBuilder;
import sweetRush.model.menu.MainMenu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;

import java.io.IOException;
import sweetRush.model.menu.Menu;
public class LevelsMenuController extends MenuController {
    public LevelsMenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        int selectedIndex = getModel().getCurrentEntry();
        int numLevels = getModel().getNumberEntries() - 1;
        if (selectedIndex < numLevels) {
            int level = selectedIndex + 1;
            game.setCurrentLevel(level);
            game.setCurrentWave(1);
            game.setState(new GameState(new LoaderArenaBuilder(level, 1, game.getNumberOfPlayers()).createArena()));
        } else {
            game.setState(new MenuState(new MainMenu()));
        }
    }
}
