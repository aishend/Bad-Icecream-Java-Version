package sweetRush.model.game.elements.monsters.movement;

import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.monsters.Monster;
import sweetRush.model.game.elements.Player;

import java.util.ArrayList;
import java.util.List;

public class ChaseMovement implements MovementStrategy {
    @Override
    public void move(Monster monster, Arena arena) {
        List<Player> players = new ArrayList<>();
        if (arena.getPlayer() != null) players.add(arena.getPlayer());
        if (arena.getPlayer2() != null) players.add(arena.getPlayer2());

        Position monsterPos = monster.getPosition();
        Position targetPos = null;
        double minDist = Double.MAX_VALUE;

        for (Player player : players) {
            Position playerPos = player.getPosition();
            double dist = Math.sqrt(Math.pow(playerPos.getX() - monsterPos.getX(), 2) + Math.pow(playerPos.getY() - monsterPos.getY(), 2));
            if (dist < minDist) {
                minDist = dist;
                targetPos = playerPos;
            }
        }

        if (targetPos == null) return;

        int dx = Integer.compare(targetPos.getX(), monsterPos.getX());
        int dy = Integer.compare(targetPos.getY(), monsterPos.getY());

        if (dx != 0) {
            Position tryX = new Position(monsterPos.getX() + dx, monsterPos.getY());
            if (arena.isEmpty(tryX) || (monster.canPassThroughMarshmallow() && arena.isMarshmallowWall(tryX))) {
                if (monster.canBreakMarshmallow() && arena.isMarshmallowWall(tryX)) {
                    arena.destroyMarshmallowWall(tryX);
                }
                monster.setPosition(tryX);
                return;
            }
        }

        if (dy != 0) {
            Position tryY = new Position(monsterPos.getX(), monsterPos.getY() + dy);
            if (arena.isEmpty(tryY) || (monster.canPassThroughMarshmallow() && arena.isMarshmallowWall(tryY))) {
                if (monster.canBreakMarshmallow() && arena.isMarshmallowWall(tryY)) {
                    arena.destroyMarshmallowWall(tryY);
                }
                monster.setPosition(tryY);
            }
        }
    }
}
