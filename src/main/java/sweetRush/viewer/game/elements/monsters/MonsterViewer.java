package sweetRush.viewer.game.elements.monsters;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.monsters.Monster;
import sweetRush.viewer.game.elements.ElementViewer;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
