package sweetRush.model.game.elements.monsters;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Monster4Test {

    @Test
    void testMonster4Creation() {
        Monster4 monster = new Monster4(3, 7);
        assertEquals(new Position(3, 7), monster.getPosition());
        assertEquals(2, monster.getSpeed());
        assertTrue(monster.canPassThroughMarshmallow());
        assertFalse(monster.canBreakMarshmallow());
    }
}