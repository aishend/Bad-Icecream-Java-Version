package sweetRush.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

class MonsterControllerTest {
    private MonsterController controller;
    private Arena arena;
    private Game game;
    private Monster monster;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        monster = mock(Monster.class);
        when(arena.getMonsters()).thenReturn(Arrays.asList(monster));
        when(monster.getSpeed()).thenReturn(1);

        controller = new MonsterController(arena);
        game = mock(Game.class);
    }

    @Test
    void moveMonster() throws IOException {
        // First step, initialize time
        controller.step(game, GUI.ACTION.NONE, 0);

        // Second step, enough time passed (500/1 = 500ms)
        controller.step(game, GUI.ACTION.NONE, 600);

        verify(monster, times(1)).move(arena);
    }

    @Test
    void doNotMoveMonsterYet() throws IOException {
        // First step
        controller.step(game, GUI.ACTION.NONE, 0);

        // Second step, not enough time (need 500ms)
        controller.step(game, GUI.ACTION.NONE, 200);

        verify(monster, never()).move(arena);
    }

    @Test
    void fastMonster() throws IOException {
        when(monster.getSpeed()).thenReturn(2); // Interval 250ms
        // Re-create controller to reset times
        controller = new MonsterController(arena);

        controller.step(game, GUI.ACTION.NONE, 0);
        controller.step(game, GUI.ACTION.NONE, 300); // +300ms > 250ms

        verify(monster, times(1)).move(arena);
    }
}

