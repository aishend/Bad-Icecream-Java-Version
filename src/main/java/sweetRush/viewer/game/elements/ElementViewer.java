package sweetRush.viewer.game.elements;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
