package sweetRush.model.game.elements.monsters;

import sweetRush.model.game.elements.monsters.movement.RandomMovement;

public class Monster4 extends Monster {
    public Monster4(int x, int y) {
        super(x, y, 2, true, false);
        this.movementStrategy = new RandomMovement();
    }
}
