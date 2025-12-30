package sweetRush.model.game.elements.monsters.movement;

import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster;

public interface MovementStrategy {
    void move(Monster monster, Arena arena);
}
