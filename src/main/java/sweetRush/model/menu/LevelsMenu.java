package sweetRush.model.menu;

import java.util.ArrayList;
import java.util.List;

public class LevelsMenu extends Menu {

    public LevelsMenu() {
        super("Levels", buildOptions());
    }

    private static String[] buildOptions() {
        List<String> options = new ArrayList<>();
        int level = 1;
        while (LevelsMenu.class.getResource("/levels/level" + level + ".lvl") != null) {
            options.add("Level " + level);
            level++;
        }
        options.add("Back to Main Menu");
        return options.toArray(new String[0]);
    }

}
