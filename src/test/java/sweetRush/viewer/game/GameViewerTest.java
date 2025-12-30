package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.arena.RandomArenaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameViewerTest {
    private GameViewer viewer;
    private Arena arena;
    private GUI gui;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        when(arena.getWidth()).thenReturn(10);
        when(arena.getHeight()).thenReturn(10);
        when(arena.getScore()).thenReturn(mock(sweetRush.model.game.Score.class));
        when(arena.getTimer()).thenReturn(mock(sweetRush.model.game.Timer.class));

        viewer = new GameViewer(arena);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDraw() throws IOException {
        when(arena.getWalls()).thenReturn(java.util.Collections.emptyList());
        when(arena.getMarshmallowWalls()).thenReturn(java.util.Collections.emptyList());
        when(arena.getCandies()).thenReturn(java.util.Collections.emptyList());
        when(arena.getMonsters()).thenReturn(java.util.Collections.emptyList());

        viewer.draw(gui);

        verify(gui).clear();
        verify(gui).refresh();
        verify(gui, atLeastOnce()).setOffset(any());
    }

    @Test
    void testDrawElements() throws IOException {
        sweetRush.model.game.elements.Player player = mock(sweetRush.model.game.elements.Player.class);
        when(player.getPosition()).thenReturn(new sweetRush.model.Position(5, 5));
        when(arena.getPlayer()).thenReturn(player);

        sweetRush.model.game.elements.candies.Candy candy = mock(sweetRush.model.game.elements.candies.Candy.class);
        when(candy.getPosition()).thenReturn(new sweetRush.model.Position(2, 2));
        when(candy.getType()).thenReturn("red");
        when(arena.getCandies()).thenReturn(java.util.Arrays.asList(candy));

        viewer.draw(gui);

        verify(gui).drawPlayer(new sweetRush.model.Position(5, 5));
        verify(gui).drawCandy(new sweetRush.model.Position(2, 2), "#FF0000");
    }
}
