package sweetRush.model.game.elements.monsters.movement;

import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster;

import java.util.Random;

public class RandomMovement implements MovementStrategy {
    @Override
    public void move(Monster monster, Arena arena) {
        Random rand = new Random();
        int dir = rand.nextInt(4);
        Position newPos = monster.getPosition();
        switch (dir) {
            case 0: newPos = newPos.getUp(); break;
            case 1: newPos = newPos.getRight(); break;
            case 2: newPos = newPos.getDown(); break;
            case 3: newPos = newPos.getLeft(); break;
        }
        if (arena.isEmpty(newPos) || (monster.canPassThroughMarshmallow() && arena.isMarshmallowWall(newPos))) {
            if (monster.canBreakMarshmallow() && arena.isMarshmallowWall(newPos)) {
                arena.destroyMarshmallowWall(newPos);
            }
            monster.setPosition(newPos);
        }
    }
}
