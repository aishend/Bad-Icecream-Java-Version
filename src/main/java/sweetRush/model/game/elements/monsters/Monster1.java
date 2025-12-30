package sweetRush.model.game.elements.monsters;

import sweetRush.model.game.elements.monsters.movement.RandomMovement;

public class Monster1 extends Monster {
    public Monster1(int x, int y) {
        super(x, y, 1);
        this.movementStrategy = new RandomMovement();
    }
}
