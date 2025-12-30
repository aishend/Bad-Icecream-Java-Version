package sweetRush.viewer.menu;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.menu.HelpMenu;
import sweetRush.model.menu.Menu;
import sweetRush.viewer.Viewer;

public class HelpMenuViewer extends Viewer<Menu> {
    public HelpMenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        HelpMenu helpMenu = (HelpMenu) getModel();

        int width = 60;
        int height = 40;

        String title = "HELP";
        int titleX = (width - title.length()) / 2;
        int titleY = 5;
        gui.drawText(new Position(titleX, titleY), title, "#FF69B4");

        int startY = 8;
        int maxLines = 20;

        for (int i = 0; i < maxLines && helpMenu.getScrollIndex() + i < helpMenu.getInstructions().size(); i++) {
            String line = helpMenu.getInstructions().get(helpMenu.getScrollIndex() + i);
            int lineX = (width - line.length()) / 2;

            String lineColor = "#FFFFFF";
            if (line.endsWith(":")) {
                lineColor = "#FFD700";
            }

            gui.drawText(new Position(lineX, startY + i), line, lineColor);
        }

        boolean selected = helpMenu.isSelected(0);
        String entry = helpMenu.getEntry(0);
        if (selected) {
            entry = "> " + entry + " <";
        }
        String color = selected ? "#FFD700" : "#FFFFFF";
        int entryX = (width - entry.length()) / 2;
        int entryY = height - 5;

        gui.drawText(new Position(entryX, entryY), entry, color);
    }
}
