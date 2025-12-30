package sweetRush.controller.game;

import sweetRush.controller.Controller;
import sweetRush.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
