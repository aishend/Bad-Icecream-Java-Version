package sweetRush.gui;

import sweetRush.model.Position;

import java.io.IOException;

public interface GUI {


    ACTION getNextAction() throws IOException;
    // quero adicionar o esc para dar pausa
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SPACE, PAUSE, W, A, S, D, F}


    void clear();
    void refresh() throws java.io.IOException;
    void close() throws java.io.IOException;


    void drawPlayer(Position position);
    void drawPlayer2(Position position);
    void drawMonster(Position position);
    void drawWall(Position position);
    void drawMarshmallowWall(Position position);
    void drawCandy(Position position, String color);
    void drawText(Position position, String text, String color);

    void setOffset(Position offset);
}
