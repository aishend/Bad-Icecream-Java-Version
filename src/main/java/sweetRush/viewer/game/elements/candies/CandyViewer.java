package sweetRush.viewer.game.elements.candies;

import sweetRush.gui.GUI;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.viewer.game.elements.ElementViewer;

public class CandyViewer implements ElementViewer<Candy> {
    @Override
    public void draw(Candy candy, GUI gui) {

        String color;
        switch (candy.getType()) {
            case "blue":
                color = "#0000FF";
                break;
            case "green":
                color = "#00FF00";
                break;
            case "red":
                color = "#FF0000";
                break;
            case "yellow":
                color = "#FFFF00";
                break;
            default:
                color = "#FF69B4";
                break;
        }
        gui.drawCandy(candy.getPosition(), color);
    }
}
