package sweetRush.states;

import sweetRush.controller.Controller;
import sweetRush.controller.menu.MenuControllerFactory;
import sweetRush.model.menu.Menu;
import sweetRush.viewer.Viewer;
import sweetRush.viewer.menu.MenuViewer;
import sweetRush.viewer.menu.HelpMenuViewer;
import sweetRush.viewer.menu.WinMenuViewer;
import sweetRush.model.menu.HelpMenu;
import sweetRush.model.menu.WinMenu;

public class MenuState extends State<Menu> {
    public MenuState(Menu menu) {
        super(menu);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        if (getModel() instanceof HelpMenu) {
            return new HelpMenuViewer(getModel());
        } else if (getModel() instanceof WinMenu) {
            return new WinMenuViewer((WinMenu) getModel());
        } else {
            return new MenuViewer(getModel());
        }
    }

    @Override
    protected Controller<Menu> getController() {
        return MenuControllerFactory.getController(getModel());
    }
}