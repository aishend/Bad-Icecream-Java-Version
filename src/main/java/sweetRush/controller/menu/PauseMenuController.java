package sweetRush.controller.menu;

import sweetRush.Game;
import sweetRush.model.game.arena.LoaderArenaBuilder;
import sweetRush.model.menu.LevelsMenu;
import sweetRush.model.menu.Menu;
import sweetRush.states.GameState;
import sweetRush.states.MenuState;

import java.io.IOException;

public class PauseMenuController extends MenuController {
    public PauseMenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void handleSelect(Game game) throws IOException {
        String selected = getModel().getSelectedEntry();
        switch (selected) {
            case "Resume" -> game.setState(game.getPreviousState());
            case "Restart" -> {
                game.setCurrentWave(1);
                game.setState(new GameState(new LoaderArenaBuilder(game.getCurrentLevel(), 1, game.getNumberOfPlayers()).createArena()));
            }
            case "Back to Levels" -> game.setState(new MenuState(new LevelsMenu()));
        }
    }
}
