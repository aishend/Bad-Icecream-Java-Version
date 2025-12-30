package sweetRush.viewer.menu;

import sweetRush.gui.GUI;
import sweetRush.model.Position;
import sweetRush.model.menu.Menu;
import sweetRush.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        String title = getModel().getTitle();
        int numberEntries = getModel().getNumberEntries();

        int width = 60;
        int height = 40;

        int titleX = (width - title.length()) / 2;
        int titleY = 15;

        gui.drawText(new Position(titleX, titleY), title, "#FF69B4");

        int startY = titleY + 4;

        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);

            if (selected) {
                entry = "> " + entry + " <";
            }

            int entryX = (width - entry.length()) / 2;
            int entryY = startY + (i * 2);

            String color = selected ? "#FFD700" : "#FFFFFF";

            gui.drawText(new Position(entryX, entryY), entry, color);
        }

        String footer = "Use ARROWS to navigate, ENTER to select";
        int footerX = (width - footer.length()) / 2;
        int footerY = height - 2;
        gui.drawText(new Position(footerX, footerY), footer, "#888888");
    }
}
