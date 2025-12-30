package sweetRush.viewer.game.elements;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class PlayerViewerTest {
    private Player player;
    private PlayerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        player = new Player(10, 10);
        viewer = new PlayerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawPlayer() {
        viewer.draw(player, gui);
        verify(gui, times(1)).drawPlayer(player.getPosition());
    }
}
