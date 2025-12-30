package sweetRush.controller.game;

import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.arena.LoaderArenaBuilder;
import sweetRush.model.menu.GameOverMenu;
import sweetRush.model.menu.PauseMenu;
import sweetRush.model.menu.WinMenu;
import sweetRush.states.MenuState;
import java.io.IOException;
import sweetRush.controller.ScoreController;
import sweetRush.controller.TimeController;

public class ArenaController extends GameController {
    private PlayerController playerController;
    private MonsterController monsterController;
    private ScoreController scoreController;
    private TimeController timeController;

    public ArenaController(Arena arena) {
        super(arena);
        this.scoreController = new ScoreController(arena.getScore());
        this.timeController = new TimeController(arena.getTimer());
        this.playerController = new PlayerController(arena, scoreController);
        this.monsterController = new MonsterController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setState(null);
            return;
        }
        if (action == GUI.ACTION.PAUSE) {
            game.setPreviousState(game.getState());
            game.setState(new MenuState(new PauseMenu()));
            return;
        }
        playerController.step(game, action, time);
        monsterController.step(game, null, time);

        if (!getModel().getTimer().isRunning()) {
            timeController.startTimer();
        }

        if (timeController.isTimeUp()) {
            game.setState(new MenuState(new GameOverMenu()));
            return;
        }

        if (getModel().getPlayer() != null && getModel().isMonster(getModel().getPlayer().getPosition())) {
            getModel().setPlayer(null);
            if (getModel().getPlayer2() == null) {
                game.setState(new MenuState(new GameOverMenu()));
            }
        }
        if (getModel().getPlayer2() != null && getModel().isMonster(getModel().getPlayer2().getPosition())) {
            getModel().setPlayer2(null);
            if (getModel().getPlayer() == null) {
                game.setState(new MenuState(new GameOverMenu()));
            }
        }

        // se os doces foremm todos apanhados passamos a proxima fase de doces
        if (getModel().getCandies().isEmpty()) {
            int nextWave = game.getCurrentWave() + 1;
            try {
                LoaderArenaBuilder builder = new LoaderArenaBuilder(game.getCurrentLevel(), nextWave, game.getNumberOfPlayers());
                getModel().setCandies(builder.getCandiesList());
                getModel().setWaveNumber(nextWave);
                game.setCurrentWave(nextWave);
            } catch (IllegalArgumentException e) {
                long remainingTime = timeController.getRemainingTime();
                int timeBonus = (int) (remainingTime / 1000) * 5;
                scoreController.addTimeBonus(remainingTime);
                game.setState(new MenuState(new WinMenu(getModel().getScore().getPoints(), timeBonus, remainingTime)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
