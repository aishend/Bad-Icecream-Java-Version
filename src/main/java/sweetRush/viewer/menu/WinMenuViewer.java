package sweetRush.viewer.menu;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.menu.WinMenu;

public class WinMenuViewer extends MenuViewer {
    public WinMenuViewer(WinMenu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        super.drawElements(gui);

        if (getModel() instanceof WinMenu winMenu) {
            int width = 60;
            int height = 40;
            int titleY = 15;
            int infoY = titleY + 2;

            String bonusText = "Bonus Time +" + winMenu.getTimeBonus() + " points (" + (winMenu.getRemainingTime() / 1000) + " seconds)";
            int bonusX = (width - bonusText.length()) / 2;

            gui.drawText(new Position(bonusX, infoY), bonusText, "#00FF00");
        }
    }
}

