package sweetRush.model.menu;

import java.util.List;
import java.util.Arrays;

public abstract class Menu {
    protected final List<String> entries;
    protected int currentEntry = 0;



    public final String title;

    public Menu(String title, String... entries) {
        this.title = title;
        this.entries = Arrays.asList(entries);
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(entries.size() - 1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public String getSelectedEntry() {
        return getEntry(currentEntry);
    }

    public String getTitle() {
        return title;
    }
}
