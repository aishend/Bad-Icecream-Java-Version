package sweetRush.controller.game;

import sweetRush.model.Direction;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;

public class WallController {
    private final Arena arena;

    public WallController(Arena arena) {
        this.arena = arena;
    }

    public void createOrDestroyWall(Position front, Direction facing) {

        boolean destroyed = false;
        Position current = front;
        while (arena.isMarshmallowWall(current) && arena.isInside(current)) {
            arena.destroyMarshmallowWall(current);
            destroyed = true;
            current = getNextPosition(current, facing);
        }

        if (!destroyed) {
            while (arena.isEmpty(current) && arena.isInside(current)) {
                arena.createMarshmallowWall(current);
                current = getNextPosition(current, facing);
            }
        }
    }

    private Position getNextPosition(Position pos, Direction dir) {
        switch (dir) {
            case UP: return pos.getUp();
            case DOWN: return pos.getDown();
            case LEFT: return pos.getLeft();
            case RIGHT: return pos.getRight();
        }
        return pos;
    }
}
