package sweetRush.model.game.elements.monsters;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Monster3Test {

    @Test
    void testMonster3Creation() {
        Monster3 monster = new Monster3(1, 8);
        assertEquals(new Position(1, 8), monster.getPosition());
        assertEquals(1, monster.getSpeed());
        assertTrue(monster.canPassThroughMarshmallow());
        assertTrue(monster.canBreakMarshmallow());
    }
}