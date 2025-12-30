package sweetRush.controller.game;

import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster;

public class MonsterController extends GameController {
    private final java.util.List<Long> lastMoveTimes;

    public MonsterController(Arena arena) {
        super(arena);
        lastMoveTimes = new java.util.ArrayList<>();
        for (int i = 0; i < arena.getMonsters().size(); i++) {
            lastMoveTimes.add(0L);
        }
    }

    @Override
    public void step(sweetRush.Game game, sweetRush.gui.GUI.ACTION action, long time) throws java.io.IOException {
        java.util.List<Monster> monsters = getModel().getMonsters();
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            long interval = 500 / monster.getSpeed(); // faster for higher speed
            if (time - lastMoveTimes.get(i) > interval) {
                monster.move(getModel());
                lastMoveTimes.set(i, time);
            }
        }
    }
}
