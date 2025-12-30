package sweetRush.viewer.game.elements.monsters;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class MonsterViewerTest {
    private Monster monster;
    private MonsterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        monster = Mockito.mock(Monster.class);
        viewer = new MonsterViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawMonster() {
        viewer.draw(monster, gui);
        verify(gui, times(1)).drawMonster(monster.getPosition());
    }
}
