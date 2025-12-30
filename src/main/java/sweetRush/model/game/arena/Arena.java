package sweetRush.model.game.arena;


import sweetRush.model.Position;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.MarshmallowWall;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.model.game.elements.monsters.Monster;
import sweetRush.model.game.Score;
import sweetRush.model.game.Timer;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Player player;
    private Player player2;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<MarshmallowWall> marshmallowWalls;
    private List<Candy> candies;
    private Score score;
    private Timer timer;
    private int waveNumber;
    private int totalWaves;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.monsters = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.marshmallowWalls = new ArrayList<>();
        this.candies = new ArrayList<>();
        this.score = new Score();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Player getPlayer2() { return player2; }
    public void setPlayer2(Player player2) { this.player2 = player2; }

    public List<Monster> getMonsters() { return monsters; }
    public void setMonsters(List<Monster> monsters) { this.monsters = monsters; }

    public List<Wall> getWalls() { return walls; }
    public void setWalls(List<Wall> walls) { this.walls = walls; }

    public List<MarshmallowWall> getMarshmallowWalls() { return marshmallowWalls; }
    public void setMarshmallowWalls(List<MarshmallowWall> marshmallowWalls) {
        this.marshmallowWalls = marshmallowWalls;
    }

    public List<Candy> getCandies() { return candies; }
    public void setCandies(List<Candy> candies) { this.candies = candies; }

    public Score getScore() { return score; }
    public void setScore(Score score) { this.score = score; }

    public Timer getTimer() { return timer; }
    public void setTimer(Timer timer) { this.timer = timer; }

    public int getWaveNumber() { return waveNumber; }
    public void setWaveNumber(int waveNumber) { this.waveNumber = waveNumber; }

    public int getTotalWaves() { return totalWaves; }
    public void setTotalWaves(int totalWaves) { this.totalWaves = totalWaves; }


    public boolean hasWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position)) return true;
        return false;
    }

    public boolean hasMarshmallow(Position position) {
        for (MarshmallowWall wall : marshmallowWalls)
            if (wall.getPosition().equals(position)) return true;
        return false;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position)) return true;
        return false;
    }

    public boolean hasCandy(Position position) {
        for (Candy candy : candies)
            if (candy.getPosition().equals(position)) return true;
        return false;
    }


    /* nao estamos a contar com o candy, depois alterar se for necessario,
    a principio nao porque candy nao interfere com objetos
    */


    // verificamos se esta dentro dos limites da arena
    public boolean isInside(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isEmpty(Position position) {
        if (!isInside(position)) return false;
        return !hasWall(position) && !hasMarshmallow(position);
    }

    public boolean isPlayer(Position position) {
        return (player != null && player.getPosition().equals(position)) || (player2 != null && player2.getPosition().equals(position));
    }

    public boolean isCandy(Position position) {
        return hasCandy(position);
    }

    public void collectCandy(Position position) {
        candies.removeIf(c -> c.getPosition().equals(position));
    }

    public boolean isMarshmallowWall(Position position) {
        return hasMarshmallow(position);
    }

    public void destroyMarshmallowWall(Position position) {
        marshmallowWalls.removeIf(w -> w.getPosition().equals(position));
    }

    public void createMarshmallowWall(Position position) {
        marshmallowWalls.add(new MarshmallowWall(position.getX(), position.getY()));
    }
}