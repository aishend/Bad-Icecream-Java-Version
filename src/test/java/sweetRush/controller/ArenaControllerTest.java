package sweetRush.controller;

import sweetRush.Game;
import sweetRush.controller.game.ArenaController;
import sweetRush.gui.GUI;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.arena.RandomArenaBuilder;
import sweetRush.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ArenaControllerTest {
    private ArenaController controller;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        RandomArenaBuilder rab = new RandomArenaBuilder(10, 10);
        arena = rab.createArena();
        controller = new ArenaController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testQuit() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 1000);
        verify(game).setState(null);
    }

    @Test
    void testPause() throws IOException {
        controller.step(game, GUI.ACTION.PAUSE, 1000);
        verify(game).setPreviousState(any());
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void testWin() throws IOException {

        arena.setCandies(java.util.Collections.emptyList());
        when(game.getCurrentWave()).thenReturn(1);
        when(game.getCurrentLevel()).thenReturn(1);
        controller.step(game, GUI.ACTION.NONE, 1000);
        verify(game).setCurrentWave(2);

        verify(game, never()).setState(any());
    }

    @Test
    void testWinEquivalencePartitions() throws IOException {

        arena.setCandies(java.util.Collections.emptyList());
        when(game.getCurrentWave()).thenReturn(1);
        when(game.getCurrentLevel()).thenReturn(1);
        controller.step(game, GUI.ACTION.NONE, 1000);
        verify(game).setCurrentWave(2);
        verify(game, never()).setState(any());

        Mockito.reset(game);
        when(game.getCurrentWave()).thenReturn(1);
        when(game.getCurrentLevel()).thenReturn(1);

        arena.setCandies(new java.util.ArrayList<>());
        arena.getCandies().add(null); // Dummy candy
        controller.step(game, GUI.ACTION.NONE, 1000);
        verify(game, never()).setCurrentWave(anyInt());
        verify(game, never()).setState(any());
    }

    @Test
    void testWinBoundaryValues() throws IOException {

        arena.setCandies(java.util.Collections.emptyList());
        when(game.getCurrentWave()).thenReturn(1);
        when(game.getCurrentLevel()).thenReturn(1);
        controller.step(game, GUI.ACTION.NONE, 1000);
        verify(game).setCurrentWave(2);

    }


    @Test
    void testPauseBoundary() throws IOException {

        controller.step(game, GUI.ACTION.PAUSE, 0);
        verify(game).setPreviousState(any());
        verify(game).setState(any(MenuState.class));
    }


    @Test
    void testQuitEquivalence() throws IOException {

        controller.step(game, GUI.ACTION.QUIT, 1000);
        verify(game).setState(null);
    }

    @Test
    void testNonQuitActions() throws IOException {

        when(game.getCurrentWave()).thenReturn(1);
        when(game.getCurrentLevel()).thenReturn(1);
        controller.step(game, GUI.ACTION.NONE, 1000);
        verify(game, never()).setState(null);
    }
}
