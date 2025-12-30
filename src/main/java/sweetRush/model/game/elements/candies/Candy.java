package sweetRush.model.game.elements.candies;

import sweetRush.model.Position;
import sweetRush.model.game.elements.Element;

public abstract class Candy extends Element {
    private final int points;
    private final String type;
    private boolean collected;

    public Candy(int x, int y, int points, String type) {
        super(x, y);
        this.points = points;
        this.type = type;
        this.collected = false;
    }

    public int getPoints() {
        return points;
    }

    public String getType() {
        return type;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        this.collected = true;
    }
}