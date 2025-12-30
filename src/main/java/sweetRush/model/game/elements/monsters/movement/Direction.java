package sweetRush.model.game.elements.monsters.movement;

import sweetRush.model.Position;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public Direction turnLeft() {
        switch (this) {
            case UP: return LEFT;
            case LEFT: return DOWN;
            case DOWN: return RIGHT;
            case RIGHT: return UP;
        }
        return this;
    }

    public Direction turnRight() {
        switch (this) {
            case UP: return RIGHT;
            case RIGHT: return DOWN;
            case DOWN: return LEFT;
            case LEFT: return UP;
        }
        return this;
    }

    public Position getNextPosition(Position pos) {
        switch (this) {
            case UP: return pos.getUp();
            case DOWN: return pos.getDown();
            case LEFT: return pos.getLeft();
            case RIGHT: return pos.getRight();
        }
        return pos;
    }
}
