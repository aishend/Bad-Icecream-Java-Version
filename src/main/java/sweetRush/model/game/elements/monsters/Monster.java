package sweetRush.model.game.elements.monsters;

import sweetRush.model.game.elements.Element;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.movement.MovementStrategy;

public abstract class Monster extends Element {
    private final int speed;
    private final boolean canPassThroughMarshmallow;
    private final boolean canBreakMarshmallow;
    protected MovementStrategy movementStrategy;

    public Monster(int x, int y, int speed) {
        this(x, y, speed, false, false);
    }

    public Monster(int x, int y, int speed, boolean canPassThroughMarshmallow) {
        this(x, y, speed, canPassThroughMarshmallow, false);
    }

    public Monster(int x, int y, int speed, boolean canPassThroughMarshmallow, boolean canBreakMarshmallow) {
        super(x, y);
        this.speed = speed;
        this.canPassThroughMarshmallow = canPassThroughMarshmallow;
        this.canBreakMarshmallow = canBreakMarshmallow;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean canPassThroughMarshmallow() {
        return canPassThroughMarshmallow;
    }

    public boolean canBreakMarshmallow() {
        return canBreakMarshmallow;
    }

    public void move(Arena arena) {
        movementStrategy.move(this, arena);
    }
}