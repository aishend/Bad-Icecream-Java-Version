package sweetRush;

import sweetRush.gui.GUI;
import sweetRush.gui.LanternaGUI;
import sweetRush.model.menu.MainMenu;
import sweetRush.states.MenuState;
import sweetRush.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final GUI gui;
    private State<?> state;
    private State<?> previousState;
    private int currentLevel = 1;
    private int currentWave = 1;
    private int numberOfPlayers = 1;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this(new LanternaGUI(60, 40));
    }

    public Game(GUI gui) {
        this.gui = gui;
        this.state = new MenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State<?> state) {
        this.state = state;
    }

    public State<?> getState() {
        return state;
    }

    public State<?> getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State<?> previousState) {
        this.previousState = previousState;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    private void start() throws IOException {
        int FPS = 20;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        gui.close();
    }
}