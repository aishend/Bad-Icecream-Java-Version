package sweetRush.model.game.arena;

import sweetRush.model.game.elements.candies.Candy;
import sweetRush.model.game.elements.candies.Blue;
import sweetRush.model.game.elements.candies.Green;
import sweetRush.model.game.elements.candies.Red;
import sweetRush.model.game.elements.candies.Yellow;

public class CandyFactory {

    public CandyFactory() {
    }

    public boolean canCreate(char type) {
        return type == 'B' || type == 'G' || type == 'R' || type == 'Y' || type == 'C';
    }

    public Candy create(char type, int x, int y) {
        if (type == 'B') return new Blue(x, y);
        else if (type == 'G') return new Green(x, y);
        else if (type == 'R') return new Red(x, y);
        else if (type == 'Y') return new Yellow(x, y);
        else if (type == 'C') return new Blue(x, y); // default
        return null;
    }
}
