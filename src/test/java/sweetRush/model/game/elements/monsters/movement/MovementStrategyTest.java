package sweetRush.model.game.elements.monsters.movement;

import org.junit.jupiter.api.Test;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster1;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovementStrategyTest {

    @Test
    void testRandomMovementMovesWhenPossible() {
        Arena arena = new Arena(10, 10);
        arena.setWalls(new ArrayList<>());
        arena.setMarshmallowWalls(new ArrayList<>());
        arena.setCandies(new ArrayList<>());
        arena.setMonsters(new ArrayList<>());

        Monster1 monster = new Monster1(5, 5);
        Position initialPos = monster.getPosition();

        RandomMovement randomMovement = new RandomMovement();
        randomMovement.move(monster, arena);

        Position newPos = monster.getPosition();
        assertNotEquals(initialPos, newPos);
        assertTrue(Math.abs(newPos.getX() - initialPos.getX()) + Math.abs(newPos.getY() - initialPos.getY()) == 1);
    }

    @Test
    void testRandomMovementDoesNotMoveWhenBlocked() {
        Arena arena = new Arena(10, 10);
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4, 5));
        walls.add(new Wall(6, 5));
        walls.add(new Wall(5, 4));
        walls.add(new Wall(5, 6));
        arena.setWalls(walls);
        arena.setMarshmallowWalls(new ArrayList<>());
        arena.setCandies(new ArrayList<>());
        arena.setMonsters(new ArrayList<>());

        Monster1 monster = new Monster1(5, 5);
        Position initialPos = monster.getPosition();

        RandomMovement randomMovement = new RandomMovement();
        randomMovement.move(monster, arena);

        assertEquals(initialPos, monster.getPosition());
    }

    @Test
    void testChaseMovementTowardsPlayer() {
        Arena arena = new Arena(10, 10);
        arena.setWalls(new ArrayList<>());
        arena.setMarshmallowWalls(new ArrayList<>());
        arena.setCandies(new ArrayList<>());
        arena.setMonsters(new ArrayList<>());

        Player player = new Player(5, 3);
        arena.setPlayer(player);

        Monster1 monster = new Monster1(5, 5);
        Position initialPos = monster.getPosition();

        ChaseMovement chaseMovement = new ChaseMovement();
        chaseMovement.move(monster, arena);

        Position newPos = monster.getPosition();
        assertEquals(new Position(5, 4), newPos);
    }

    @Test
    void testLeftMovement() {
        Arena arena = new Arena(10, 10);
        arena.setWalls(new ArrayList<>());
        arena.setMarshmallowWalls(new ArrayList<>());
        arena.setCandies(new ArrayList<>());
        arena.setMonsters(new ArrayList<>());

        Monster1 monster = new Monster1(5, 5);
        Position initialPos = monster.getPosition();

        LeftMovement leftMovement = new LeftMovement();
        leftMovement.move(monster, arena);

        Position newPos = monster.getPosition();
        assertEquals(new Position(5, 4), newPos);
    }
}
