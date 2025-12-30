package sweetRush.model.game.elements.monsters;

import sweetRush.model.game.elements.monsters.movement.LeftMovement;

public class Monster3 extends Monster {
    public Monster3(int x, int y) {
        super(x, y, 1, true, true);
        this.movementStrategy = new LeftMovement();
    }
}
