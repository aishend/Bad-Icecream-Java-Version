package sweetRush.model.game.arena;

import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.Wall;
import sweetRush.model.game.elements.MarshmallowWall;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.model.game.elements.monsters.Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final int wave;
    private final int numberOfPlayers;
    private final int totalWaves;
    private final List<String> lines;
    private final long timerDuration;
    private final MonsterFactory monsterFactory = new MonsterFactory();
    private final CandyFactory candyFactory = new CandyFactory();

    public LoaderArenaBuilder(int level) throws IOException {
        this(level, 1, 1);
    }

    public LoaderArenaBuilder(int level, int wave) throws IOException {
        this(level, wave, 1);
    }

    public LoaderArenaBuilder(int level, int wave, int numberOfPlayers) throws IOException {
        this.level = level;
        this.wave = wave;
        this.numberOfPlayers = numberOfPlayers;
        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()));
        List<String> allLines = readLines(br);
        List<List<String>> sections = splitIntoSections(allLines);
        this.totalWaves = sections.size();
        if (wave < 1 || wave > sections.size()) {
            throw new IllegalArgumentException("Invalid wave number");
        }
        List<String> waveLines = new ArrayList<>(sections.get(wave - 1));
        long parsedTimer = 60000L;
        while (!waveLines.isEmpty() && waveLines.get(0).startsWith("TIME=")) {
            if (parsedTimer == 60000L) {
                try {
                    int seconds = Integer.parseInt(waveLines.get(0).substring(5));
                    parsedTimer = seconds * 1000L;
                } catch (NumberFormatException e) {
                    // keep default
                }
            }
            waveLines.remove(0);
        }
        this.lines = waveLines;
        this.timerDuration = parsedTimer;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    private List<List<String>> splitIntoSections(List<String> allLines) {
        List<List<String>> sections = new ArrayList<>();
        List<String> current = new ArrayList<>();
        for (String line : allLines) {
            if (line.trim().isEmpty()) {
                if (!current.isEmpty()) {
                    sections.add(new ArrayList<>(current));
                    current.clear();
                }
            } else {
                current.add(line);
            }
        }
        if (!current.isEmpty()) sections.add(current);
        return sections;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected Player createPlayer() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') return new Player(x, y);
        }
        return null;
    }

    @Override
    protected Player createPlayer2() {
        if (numberOfPlayers < 2) return null;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'Q') return new Player(x, y);
        }
        return null;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                if (monsterFactory.canCreate(c)) monsters.add(monsterFactory.create(c, x, y));
            }
        }
        return monsters;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }
        return walls;
    }

    @Override
    protected List<MarshmallowWall> createMarshmallowWalls() {
        List<MarshmallowWall> marshmallowWalls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '@') marshmallowWalls.add(new MarshmallowWall(x, y));
        }
        return marshmallowWalls;
    }

    @Override
    protected List<Candy> createCandies() {
        List<Candy> candies = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                if (candyFactory.canCreate(c)) candies.add(candyFactory.create(c, x, y));
            }
        }
        return candies;
    }

    public List<Candy> getCandiesList() {
        return createCandies();
    }

    public long getTimerDurationValue() {
        return timerDuration;
    }

    @Override
    protected long getTimerDuration() {
        return timerDuration;
    }

    @Override
    protected int getWaveNumber() {
        return wave;
    }

    @Override
    protected int getTotalWaves() {
        return totalWaves;
    }
}