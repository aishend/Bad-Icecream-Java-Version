package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.monsters.Monster1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import sweetRush.model.game.Timer;
import sweetRush.model.game.Score;


class ArenaViewerTest {
        private GUI gui;
        private GameViewer viewer;
        private Arena arena;

        @BeforeEach
        void setUp() {
            arena = new Arena(10, 10);
            arena.setScore(new Score());
            arena.setTimer(new Timer(60000));
            gui = Mockito.mock(GUI.class);
            viewer = new GameViewer(arena);

            arena.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
            arena.setMonsters(Arrays.asList(new Monster1(4, 5), new Monster1(5, 6)));
            arena.setPlayer(new Player(5, 8));
        }


        @Test
        void drawWalls() throws IOException {
            viewer.draw(gui);

            Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
            Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
            Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
            Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
        }

        @Test
        void drawMonsters() throws IOException {
            viewer.draw(gui);

            Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(4, 5));
            Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(5, 6));
            Mockito.verify(gui, Mockito.times(2)).drawMonster(Mockito.any(Position.class));
        }

        @Test
        void drawHero() throws IOException {
            viewer.draw(gui);

            Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5, 8));
            Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
        }

        @Test
        void drawCandies() {

        }

        @Test
        void drawScore() {
        }


        @Test
        void refreshAndClear() throws IOException {
            viewer.draw(gui);

            Mockito.verify(gui, Mockito.times(1)).clear();
            Mockito.verify(gui, Mockito.times(1)).refresh();
        }
    }