package sweetRush.model.game.arena;

import sweetRush.model.game.Timer;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.MarshmallowWall;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.model.game.elements.monsters.Monster;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setTimer(new Timer(getTimerDuration()));

        arena.setPlayer(createPlayer());
        arena.setPlayer2(createPlayer2());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setMarshmallowWalls(createMarshmallowWalls());
        arena.setCandies(createCandies());
        arena.setWaveNumber(getWaveNumber());
        arena.setTotalWaves(getTotalWaves());

        return arena;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();

    protected abstract Player createPlayer();
    protected abstract Player createPlayer2();
    protected abstract List<Monster> createMonsters();
    protected abstract List<Wall> createWalls();
    protected abstract List<MarshmallowWall> createMarshmallowWalls();
    protected abstract List<Candy> createCandies();
    protected abstract long getTimerDuration();

    protected int getWaveNumber() {
        return 1;
    }

    protected int getTotalWaves() {
        return 1;
    }
}