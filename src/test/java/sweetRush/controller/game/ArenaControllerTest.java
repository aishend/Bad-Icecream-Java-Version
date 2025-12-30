package sweetRush.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.model.game.Score;
import sweetRush.model.game.Timer;
import sweetRush.model.menu.GameOverMenu;
import sweetRush.model.menu.PauseMenu;
import sweetRush.model.menu.WinMenu;
import sweetRush.states.MenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArenaControllerTest {
    private ArenaController controller;
    private Arena arena;
    private Game game;
    private Timer timer;
    private Score score;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        timer = mock(Timer.class);
        score = mock(Score.class);
        when(arena.getTimer()).thenReturn(timer);
        when(arena.getScore()).thenReturn(score);
        when(arena.getMonsters()).thenReturn(Collections.emptyList());
        when(arena.getCandies()).thenReturn(Arrays.asList(mock(Candy.class)));

        controller = new ArenaController(arena);
        game = mock(Game.class);
    }

    @Test
    void quitGame() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 100);
        verify(game).setState(null);
    }

    @Test
    void pauseGame() throws IOException {
        controller.step(game, GUI.ACTION.PAUSE, 100);
        verify(game).setPreviousState(any());
        verify(game).setState(argThat(state -> state instanceof MenuState && ((MenuState)state).getModel() instanceof PauseMenu));
    }

    @Test
    void gameOverTimeUp() throws IOException {
        when(timer.isRunning()).thenReturn(true);
        when(timer.isFinished()).thenReturn(true);
        when(timer.getRemainingTime()).thenReturn(0L);

        controller.step(game, GUI.ACTION.NONE, 100);

        verify(game).setState(argThat(state -> state instanceof MenuState && ((MenuState)state).getModel() instanceof GameOverMenu));
    }

    @Test
    void gameOverCollision() throws IOException {
        Player player = mock(Player.class);
        when(arena.getPlayer()).thenReturn(player);
        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isMonster(new Position(5, 5))).thenReturn(true);
        when(timer.getRemainingTime()).thenReturn(10000L);

        controller.step(game, GUI.ACTION.NONE, 100);

        verify(arena).setPlayer(null);
        verify(game).setState(argThat(state -> state instanceof MenuState && ((MenuState)state).getModel() instanceof GameOverMenu));
    }

    @Test
    void winLevel() throws IOException {
        when(arena.getCandies()).thenReturn(Collections.emptyList());
        when(timer.getRemainingTime()).thenReturn(10000L);
        when(score.getPoints()).thenReturn(100);

        when(game.getCurrentLevel()).thenReturn(1);
        when(game.getCurrentWave()).thenReturn(3);

        controller.step(game, GUI.ACTION.NONE, 100);

        verify(game).setState(argThat(state -> state instanceof MenuState && ((MenuState)state).getModel() instanceof WinMenu));
    }
}

