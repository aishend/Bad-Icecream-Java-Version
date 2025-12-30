package sweetRush.model.game.arena;

import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.MarshmallowWall;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.model.game.elements.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class RandomArenaBuilder extends ArenaBuilder {
    private final int width;
    private final int height;

    public RandomArenaBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected Player createPlayer() {
        return new Player(1, 1);
    }

    @Override
    protected Player createPlayer2() {
        return new Player(2, 2);
    }

    @Override
    protected List<Monster> createMonsters() {
        return new ArrayList<>();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }
        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }
        return walls;
    }

    @Override
    protected List<MarshmallowWall> createMarshmallowWalls() {
        return new ArrayList<>();
    }

    @Override
    protected List<Candy> createCandies() {
        return new ArrayList<>();
    }

    @Override
    protected long getTimerDuration() {
        return 60000L;
    }
}
