package sweetRush.model.game.elements;

import sweetRush.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void testConstructor() {
        Element element = new Element(5, 10);
        assertEquals(new Position(5, 10), element.getPosition());
    }

    @Test
    void testSetPosition() {
        Element element = new Element(0, 0);
        Position newPos = new Position(3, 7);
        element.setPosition(newPos);
        assertEquals(newPos, element.getPosition());
    }

    @Test
    void testGetPosition() {
        Element element = new Element(-1, -1);
        assertEquals(new Position(-1, -1), element.getPosition());
    }
}
