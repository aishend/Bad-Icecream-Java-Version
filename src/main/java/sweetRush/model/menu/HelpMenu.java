package sweetRush.model.menu;

import java.util.List;
import java.util.Arrays;

public class HelpMenu extends Menu {
    private final List<String> instructions;
    private int scrollIndex;

    public HelpMenu() {
        super("Help", "Back to Main Menu");
        instructions = Arrays.asList(
                "Welcome to SweetRush!",
                "",
                "OBJECTIVE:",
                "Collect all the candies scattered",
                "around the arena to win the level.",
                "Avoid the monsters chasing you!",
                "",
                "CONTROLS (Player 1):",
                "Arrow Keys : Move Player",
                "Space : Build/Destroy Walls",
                "",
                "CONTROLS (Player 2):",
                "W, A, S, D : Move Player",
                "F : Build/Destroy Walls",
                "",
                "GENERAL:",
                "P : Pause Game",
                "Q : Quit Game",
                "",
                "MECHANICS:",
                "- Monsters will hunt you down.",
                "- Use walls to block their path.",
                "- Walls are temporary or breakable.",
                "- Be fast and strategic!",
                "",
                "Good Luck!"
        );
        scrollIndex = 0;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public int getScrollIndex() {
        return scrollIndex;
    }

    public void scrollUp() {
        if (scrollIndex > 0) scrollIndex--;
    }

    public void scrollDown() {
        if (scrollIndex < instructions.size() - 1) scrollIndex++;
    }

}
