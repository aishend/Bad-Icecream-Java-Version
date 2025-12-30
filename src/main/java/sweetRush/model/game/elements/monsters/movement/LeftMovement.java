package sweetRush.model.game.elements.monsters.movement;

import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster;

public class LeftMovement implements MovementStrategy {
    private Direction currentDirection = Direction.RIGHT;

    @Override
    public void move(Monster monster, Arena arena) {
        Position current = monster.getPosition();

        Direction leftDir = currentDirection.turnLeft();
        Position leftPos = leftDir.getNextPosition(current);
        if (canMoveTo(monster, leftPos, arena)) {
            currentDirection = leftDir;
            moveTo(monster, leftPos, arena);
            return;
        }

        Position straightPos = currentDirection.getNextPosition(current);
        if (canMoveTo(monster, straightPos, arena)) {
            moveTo(monster, straightPos, arena);
            return;
        }

        Direction rightDir = currentDirection.turnRight();
        Position rightPos = rightDir.getNextPosition(current);
        if (canMoveTo(monster, rightPos, arena)) {
            currentDirection = rightDir;
            moveTo(monster, rightPos, arena);
            return;
        }

        Direction backDir = currentDirection.turnRight().turnRight();
        Position backPos = backDir.getNextPosition(current);
        if (canMoveTo(monster, backPos, arena)) {
            currentDirection = backDir;
            moveTo(monster, backPos, arena);
            return;
        }
    }

    private boolean canMoveTo(Monster monster, Position pos, Arena arena) {
        return arena.isEmpty(pos) || (monster.canPassThroughMarshmallow() && arena.isMarshmallowWall(pos));
    }

    private void moveTo(Monster monster, Position pos, Arena arena) {
        if (monster.canBreakMarshmallow() && arena.isMarshmallowWall(pos)) {
            arena.destroyMarshmallowWall(pos);
        }
        monster.setPosition(pos);
    }
}
