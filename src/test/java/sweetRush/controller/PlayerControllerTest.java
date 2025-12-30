package sweetRush.controller;

import sweetRush.controller.game.PlayerController;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Arena arena;


    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5);
        arena.setPlayer(player);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setCandies(Arrays.asList());

        ScoreController scoreController = new ScoreController(arena.getScore());
        controller = new PlayerController(arena, scoreController);
    }

    @Test
    void movePlayerRightEmpty() {
        controller.movePlayerRight(arena.getPlayer());
        assertEquals(new Position(6, 5), player.getPosition());
    }

    @Test
    void movePlayerRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.movePlayerRight(arena.getPlayer());
        assertEquals(new Position(5, 5), player.getPosition());
    }

    @Test
    void testCollectCandy() {

        sweetRush.model.game.elements.candies.Red candy = new sweetRush.model.game.elements.candies.Red(6, 5);
        arena.setCandies(new java.util.ArrayList<>());
        arena.getCandies().add(candy);
        controller.movePlayerRight(arena.getPlayer());
        assertEquals(new Position(6, 5), player.getPosition());

        assertTrue(arena.getCandies().isEmpty());
    }
}