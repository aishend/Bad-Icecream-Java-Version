package sweetRush.model.game.arena;

import sweetRush.model.game.elements.monsters.Monster;
import sweetRush.model.game.elements.monsters.Monster1;
import sweetRush.model.game.elements.monsters.Monster2;
import sweetRush.model.game.elements.monsters.Monster3;
import sweetRush.model.game.elements.monsters.Monster4;

public class MonsterFactory {

    public MonsterFactory() {
    }

    public boolean canCreate(char type) {
        return type == 'X' || type == 'T' || type == 'Z' || type == 'W';
    }

    public Monster create(char type, int x, int y) {
        if (type == 'X') return new Monster1(x, y);
        else if (type == 'T') return new Monster2(x, y);
        else if (type == 'Z') return new Monster3(x, y);
        else if (type == 'W') return new Monster4(x, y);
        return null;
    }
}
