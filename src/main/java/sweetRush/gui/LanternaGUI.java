package sweetRush.gui;

import sweetRush.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private Position offset = new Position(0, 0);

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 50);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        if (keyStroke.getKeyType() == KeyType.Character) {
            if (keyStroke.getCharacter() == ' ') return ACTION.SPACE;
            if (keyStroke.getCharacter() == 'p' || keyStroke.getCharacter() == 'P') return ACTION.PAUSE;
            if (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q') return ACTION.QUIT;
            if (keyStroke.getCharacter() == 'w' || keyStroke.getCharacter() == 'W') return ACTION.W;
            if (keyStroke.getCharacter() == 'a' || keyStroke.getCharacter() == 'A') return ACTION.A;
            if (keyStroke.getCharacter() == 's' || keyStroke.getCharacter() == 'S') return ACTION.S;
            if (keyStroke.getCharacter() == 'd' || keyStroke.getCharacter() == 'D') return ACTION.D;
            if (keyStroke.getCharacter() == 'f' || keyStroke.getCharacter() == 'F') return ACTION.F;
        }

        return ACTION.NONE;
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY(), 'P', "#FFD700");
    }

    @Override
    public void drawPlayer2(Position position) {
        drawCharacter(position.getX(), position.getY(), 'p', "#00FF00");
    }

    @Override
    public void drawMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), 'M', "#CC0000");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), ' ', "#8B4513", "#8B4513");
    }

    @Override
    public void drawMarshmallowWall(Position position) {
        drawCharacter(position.getX(), position.getY(), ' ', "#FF69B4", "#FF69B4");
    }

    @Override
    public void drawCandy(Position position, String colorHex) {
        drawCharacter(position.getX(), position.getY(), '*', colorHex);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX() + offset.getX(), position.getY() + offset.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        drawCharacter(x, y, c, color, null);
    }

    private void drawCharacter(int x, int y, char c, String color, String backgroundColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        if (backgroundColor != null) {
            tg.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        }
        tg.putString(x + offset.getX(), y + offset.getY() + 1, "" + c);
    }

    @Override
    public void setOffset(Position offset) {
        this.offset = offset;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}