package sweetRush.model.game.elements.monsters;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Monster2Test {

    @Test
    void testMonster2Creation() {
        Monster2 monster = new Monster2(2, 3);
        assertEquals(new Position(2, 3), monster.getPosition());
        assertEquals(2, monster.getSpeed());
        assertFalse(monster.canPassThroughMarshmallow());
        assertFalse(monster.canBreakMarshmallow());
    }
}