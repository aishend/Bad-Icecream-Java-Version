package sweetRush.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sweetRush.model.Position;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawPlayer() {
        gui.drawPlayer(new Position(2, 3));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg, Mockito.times(1)).putString(2, 4, "P");
    }

    @Test
    void drawPlayer2() {
        gui.drawPlayer2(new Position(3, 4));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        Mockito.verify(tg, Mockito.times(1)).putString(3, 5, "p");
    }

    @Test
    void drawMonster() {
        gui.drawMonster(new Position(4, 5));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        Mockito.verify(tg, Mockito.times(1)).putString(4, 6, "M");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(5, 6));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#8B4513"));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#8B4513"));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 7, " ");
    }

    @Test
    void drawMarshmallowWall() {
        gui.drawMarshmallowWall(new Position(6, 7));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF69B4"));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FF69B4"));
        Mockito.verify(tg, Mockito.times(1)).putString(6, 8, " ");
    }

    @Test
    void drawCandy() {
        gui.drawCandy(new Position(7, 8), "#FF0000");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(tg, Mockito.times(1)).putString(7, 9, "*");
    }

    @Test
    void setOffset() {
        Position newOffset = new Position(10, 20);
        gui.setOffset(newOffset);

        gui.drawText(new Position(1, 1), "test", "#000000");
        Mockito.verify(tg, Mockito.times(1)).putString(11, 21, "test");
    }

    @Test
    void clear() {
        gui.clear();

        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void close() throws IOException {
        gui.close();

        Mockito.verify(screen, Mockito.times(1)).close();
    }

    @Test
    void getNextActionNone() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);

        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }

    @Test
    void getNextActionQuitEOF() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());
    }

    @Test
    void getNextActionQuitQ() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('q');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());
    }

    @Test
    void getNextActionUp() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.UP, gui.getNextAction());
    }

    @Test
    void getNextActionRight() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.RIGHT, gui.getNextAction());
    }

    @Test
    void getNextActionDown() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.DOWN, gui.getNextAction());
    }

    @Test
    void getNextActionLeft() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.LEFT, gui.getNextAction());
    }

    @Test
    void getNextActionSelect() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.SELECT, gui.getNextAction());
    }

    @Test
    void getNextActionSpace() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn(' ');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.SPACE, gui.getNextAction());
    }

    @Test
    void getNextActionPause() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('p');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.PAUSE, gui.getNextAction());
    }

    @Test
    void getNextActionW() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('w');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.W, gui.getNextAction());
    }

    @Test
    void getNextActionA() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('a');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.A, gui.getNextAction());
    }

    @Test
    void getNextActionS() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('s');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.S, gui.getNextAction());
    }

    @Test
    void getNextActionD() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('d');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.D, gui.getNextAction());
    }

    @Test
    void getNextActionF() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('f');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.F, gui.getNextAction());
    }

    @Test
    void getNextActionEscape() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }

    @Test
    void getNextActionUnknown() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('z');
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }
}