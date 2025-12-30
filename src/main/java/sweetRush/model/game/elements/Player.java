package sweetRush.model.game.elements;

import sweetRush.model.Direction;
import sweetRush.model.Position;

public class Player extends Element {
    private int lives;
    private Direction facing;

    public Player(int x, int y) {
        super(x, y);
        this.lives = 3;
        this.facing = Direction.UP;
    }

    public void decreaseLife() {
        lives--;
    }

    public int getLives() {
        return lives;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    public Direction getFacing() {
        return facing;
    }

    public Position getFacingPosition() {
        switch (facing) {
            case UP: return getPosition().getUp();
            case DOWN: return getPosition().getDown();
            case LEFT: return getPosition().getLeft();
            case RIGHT: return getPosition().getRight();
        }
        return getPosition().getUp();
    }
}

