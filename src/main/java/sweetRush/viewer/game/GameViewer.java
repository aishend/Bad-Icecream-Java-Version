package sweetRush.viewer.game;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Element;
import sweetRush.viewer.Viewer;
import sweetRush.viewer.game.elements.ElementViewer;
import sweetRush.viewer.game.elements.MarshmallowWallViewer;
import sweetRush.viewer.game.elements.PlayerViewer;
import sweetRush.viewer.game.elements.WallViewer;
import sweetRush.viewer.game.elements.candies.CandyViewer;
import sweetRush.viewer.game.elements.monsters.MonsterViewer;
import sweetRush.model.game.elements.candies.Candy;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GameViewer extends Viewer<Arena> {
    private final ScoreViewer scoreViewer;
    private final TimerViewer timerViewer;

    public GameViewer(Arena arena) {
        super(arena);
        this.scoreViewer = new ScoreViewer(arena.getScore());
        this.timerViewer = new TimerViewer(arena.getTimer());
    }

    @Override
    protected void drawElements(GUI gui) {
        int offsetX = (60 - getModel().getWidth()) / 2;
        int offsetY = (40 - getModel().getHeight()) / 2;
        gui.setOffset(new Position(offsetX, offsetY));

        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMarshmallowWalls(), new MarshmallowWallViewer());
        for (Candy candy : getModel().getCandies()) {
            boolean hasWall = getModel().getMarshmallowWalls().stream().anyMatch(w -> w.getPosition().equals(candy.getPosition()));
            String color;
            if (hasWall) {
                color = "#FF69B4";
            } else {
                switch (candy.getType()) {
                    case "blue":
                        color = "#0000FF";
                        break;
                    case "green":
                        color = "#00FF00";
                        break;
                    case "red":
                        color = "#FF0000";
                        break;
                    case "yellow":
                        color = "#FFFF00";
                        break;
                    default:
                        color = "#FF69B4";
                        break;
                }
            }
            gui.drawCandy(candy.getPosition(), color);
        }
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        if (getModel().getPlayer() != null) {
            drawElement(gui, getModel().getPlayer(), new PlayerViewer());
        }
        if (getModel().getPlayer2() != null) {
            gui.drawPlayer2(getModel().getPlayer2().getPosition());
        }

        gui.setOffset(new Position(0, 0));
        scoreViewer.draw(gui);
        timerViewer.draw(gui);
        drawWaveInfo(gui);
    }

    private void drawWaveInfo(GUI gui) {
        int wave = getModel().getWaveNumber();
        int totalWaves = getModel().getTotalWaves();
        gui.drawText(new Position(1, 2), "Wave " + wave + "/" + totalWaves, "#FFFFFF");

        Map<String, Integer> candyCounts = new HashMap<>();
        for (Candy candy : getModel().getCandies()) {
            candyCounts.put(candy.getType(), candyCounts.getOrDefault(candy.getType(), 0) + 1);
        }

        int y = 4;
        for (Map.Entry<String, Integer> entry : candyCounts.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();
            String color = "#FFFFFF";
            switch (type) {
                case "blue": color = "#0000FF"; break;
                case "green": color = "#00FF00"; break;
                case "red": color = "#FF0000"; break;
                case "yellow": color = "#FFFF00"; break;
            }
            gui.drawText(new Position(1, y), count + "x " + type, color);
            y++;
        }
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}