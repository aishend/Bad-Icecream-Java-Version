package sweetRush.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sweetRush.model.Direction;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;

import static org.mockito.Mockito.*;

class WallControllerTest {
    private WallController controller;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        controller = new WallController(arena);
    }

    @Test
    void destroyWall() {
        Position start = new Position(5, 5);
        when(arena.isMarshmallowWall(start)).thenReturn(true);
        when(arena.isInside(start)).thenReturn(true);

        // Next position is empty, so loop stops
        when(arena.isMarshmallowWall(new Position(5, 4))).thenReturn(false);

        controller.createOrDestroyWall(start, Direction.UP);

        verify(arena).destroyMarshmallowWall(start);
        verify(arena, never()).createMarshmallowWall(any());
    }

    @Test
    void createWall() {
        Position start = new Position(5, 5);
        when(arena.isMarshmallowWall(start)).thenReturn(false);
        when(arena.isEmpty(start)).thenReturn(true);
        when(arena.isInside(start)).thenReturn(true);

        // Next position is blocked
        when(arena.isEmpty(new Position(5, 4))).thenReturn(false);

        controller.createOrDestroyWall(start, Direction.UP);

        verify(arena).createMarshmallowWall(start);
        verify(arena, never()).destroyMarshmallowWall(any());
    }

    @Test
    void createMultipleWalls() {
        Position p1 = new Position(5, 5);
        Position p2 = new Position(5, 4);
        Position p3 = new Position(5, 3);

        when(arena.isMarshmallowWall(p1)).thenReturn(false);

        when(arena.isEmpty(p1)).thenReturn(true);
        when(arena.isInside(p1)).thenReturn(true);

        when(arena.isEmpty(p2)).thenReturn(true);
        when(arena.isInside(p2)).thenReturn(true);

        when(arena.isEmpty(p3)).thenReturn(false); // Blocked

        controller.createOrDestroyWall(p1, Direction.UP);

        verify(arena).createMarshmallowWall(p1);
        verify(arena).createMarshmallowWall(p2);
        verify(arena, never()).createMarshmallowWall(p3);
    }
}

