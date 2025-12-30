package sweetRush.model.game.elements.monsters;

import sweetRush.model.game.elements.monsters.movement.ChaseMovement;

public class Monster2 extends Monster {
    public Monster2(int x, int y) {
        super(x, y, 2);
        this.movementStrategy = new ChaseMovement();
    }
}