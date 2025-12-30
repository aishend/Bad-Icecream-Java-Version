package sweetRush.controller;

import sweetRush.Game;
import sweetRush.controller.game.MonsterController;
import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.monsters.Monster;
import sweetRush.model.game.elements.monsters.Monster1;
import sweetRush.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MonsterControllerTest {
    private MonsterController controller;
    private Player player;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5);
        arena.setPlayer(player);

        arena.setWalls(Arrays.asList());

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsters() throws IOException {
        Monster monster = new Monster1(5, 5);
        arena.setMonsters(Arrays.asList(monster));

        controller = new MonsterController(arena);

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersClosed() throws IOException {
        Monster monster = new Monster1(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        controller = new MonsterController(arena);

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Monster monster = new Monster1(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        controller = new MonsterController(arena);

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }
}