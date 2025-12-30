package sweetRush.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sweetRush.Game;
import sweetRush.controller.ScoreController;
import sweetRush.gui.GUI;
import sweetRush.model.Direction;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.candies.Candy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class PlayerControllerTest {
    private PlayerController controller;
    private Arena arena;
    private ScoreController scoreController;
    private Game game;
    private Player player;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        scoreController = mock(ScoreController.class);
        controller = new PlayerController(arena, scoreController);
        game = mock(Game.class);
        player = mock(Player.class);
        when(arena.getPlayer()).thenReturn(player);
        when(player.getPosition()).thenReturn(new Position(5, 5));
    }

    @Test
    void movePlayerUp() {
        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isEmpty(new Position(5, 4))).thenReturn(true);

        controller.step(game, GUI.ACTION.UP, 100);

        verify(player).setPosition(new Position(5, 4));
        verify(player).setFacing(Direction.UP);
    }

    @Test
    void movePlayerRight() {
        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isEmpty(new Position(6, 5))).thenReturn(true);

        controller.step(game, GUI.ACTION.RIGHT, 100);

        verify(player).setPosition(new Position(6, 5));
        verify(player).setFacing(Direction.RIGHT);
    }

    @Test
    void movePlayerDown() {
        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isEmpty(new Position(5, 6))).thenReturn(true);

        controller.step(game, GUI.ACTION.DOWN, 100);

        verify(player).setPosition(new Position(5, 6));
        verify(player).setFacing(Direction.DOWN);
    }

    @Test
    void movePlayerLeft() {
        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isEmpty(new Position(4, 5))).thenReturn(true);

        controller.step(game, GUI.ACTION.LEFT, 100);

        verify(player).setPosition(new Position(4, 5));
        verify(player).setFacing(Direction.LEFT);
    }

    @Test
    void movePlayerBlocked() {
        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isEmpty(new Position(5, 4))).thenReturn(false);

        controller.step(game, GUI.ACTION.UP, 100);

        verify(player, never()).setPosition(new Position(5, 4));
    }

    @Test
    void collectCandy() {
        Position candyPos = new Position(5, 4);
        Candy candy = mock(Candy.class);
        when(candy.getPosition()).thenReturn(candyPos);
        when(candy.getPoints()).thenReturn(10);

        when(player.getPosition()).thenReturn(new Position(5, 5));
        when(arena.isEmpty(candyPos)).thenReturn(true);
        when(arena.isCandy(candyPos)).thenReturn(true);
        when(arena.getCandies()).thenReturn(Collections.singletonList(candy));

        controller.step(game, GUI.ACTION.UP, 100);

        verify(player).setPosition(candyPos);
        verify(scoreController).addCandyPoints(10);
        verify(arena).collectCandy(candyPos);
    }

    @Test
    void player2Movement() {
        Player player2 = mock(Player.class);
        when(arena.getPlayer2()).thenReturn(player2);
        when(player2.getPosition()).thenReturn(new Position(10, 10));
        when(arena.isEmpty(new Position(10, 9))).thenReturn(true);

        controller.step(game, GUI.ACTION.W, 100);

        verify(player2).setPosition(new Position(10, 9));
        verify(player2).setFacing(Direction.UP);
    }

    @Test
    void createWall() {
        when(player.getFacingPosition()).thenReturn(new Position(5, 4));
        when(player.getFacing()).thenReturn(Direction.UP);
        when(arena.isEmpty(new Position(5, 4))).thenReturn(true);
        when(arena.isInside(new Position(5, 4))).thenReturn(true);
        when(arena.isEmpty(new Position(5, 3))).thenReturn(false);

        controller.step(game, GUI.ACTION.SPACE, 100);

        verify(arena).createMarshmallowWall(new Position(5, 4));
    }
}

