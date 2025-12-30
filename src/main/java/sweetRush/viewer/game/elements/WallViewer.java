package sweetRush.viewer.game.elements;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
