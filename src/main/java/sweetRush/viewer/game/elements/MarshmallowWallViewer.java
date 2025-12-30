package sweetRush.viewer.game.elements;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.MarshmallowWall;

public class MarshmallowWallViewer implements ElementViewer<MarshmallowWall> {
    @Override
    public void draw(MarshmallowWall wall, GUI gui) {
        gui.drawMarshmallowWall(wall.getPosition());
    }
}
