package sweetRush.states;

import sweetRush.controller.Controller;
import sweetRush.controller.game.ArenaController;
import sweetRush.model.game.arena.Arena;
import sweetRush.viewer.Viewer;
import sweetRush.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
