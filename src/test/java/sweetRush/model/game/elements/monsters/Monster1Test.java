package sweetRush.model.game.elements.monsters;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Monster1Test {

    @Test
    void testMonster1Creation() {
        Monster1 monster = new Monster1(5, 5);
        assertEquals(new Position(5, 5), monster.getPosition());
        assertEquals(1, monster.getSpeed());
        assertFalse(monster.canPassThroughMarshmallow());
        assertFalse(monster.canBreakMarshmallow());
    }
}