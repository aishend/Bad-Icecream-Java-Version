package sweetRush.controller.game;

import sweetRush.Game;
import sweetRush.gui.GUI;
import sweetRush.model.Direction;
import sweetRush.model.Position;
import sweetRush.model.game.arena.Arena;
import sweetRush.model.game.elements.Player;
import sweetRush.model.game.elements.candies.Candy;
import sweetRush.controller.ScoreController;

public class PlayerController extends GameController {
    private final WallController wallController;
    private ScoreController scoreController;

    public PlayerController(Arena arena, ScoreController scoreController) {
        super(arena);
        this.wallController = new WallController(arena);
        this.scoreController = scoreController;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (getModel().getPlayer() != null) {
            if (action == GUI.ACTION.UP)    movePlayerUp(getModel().getPlayer());
            if (action == GUI.ACTION.RIGHT) movePlayerRight(getModel().getPlayer());
            if (action == GUI.ACTION.DOWN)  movePlayerDown(getModel().getPlayer());
            if (action == GUI.ACTION.LEFT)  movePlayerLeft(getModel().getPlayer());
            if (action == GUI.ACTION.SPACE) createOrDestroyWall(getModel().getPlayer());
        }
        if (getModel().getPlayer2() != null) {
            if (action == GUI.ACTION.W) movePlayerUp(getModel().getPlayer2());
            if (action == GUI.ACTION.D) movePlayerRight(getModel().getPlayer2());
            if (action == GUI.ACTION.S) movePlayerDown(getModel().getPlayer2());
            if (action == GUI.ACTION.A) movePlayerLeft(getModel().getPlayer2());
            if (action == GUI.ACTION.F) createOrDestroyWall(getModel().getPlayer2());
        }
    }

    public void movePlayerUp(Player player) {
        movePlayer(player, player.getPosition().getUp());
        player.setFacing(sweetRush.model.Direction.UP);
    }

    public void movePlayerRight(Player player) {
        movePlayer(player, player.getPosition().getRight());
        player.setFacing(sweetRush.model.Direction.RIGHT);
    }

    public void movePlayerDown(Player player) {
        movePlayer(player, player.getPosition().getDown());
        player.setFacing(sweetRush.model.Direction.DOWN);
    }

    public void movePlayerLeft(Player player) {
        movePlayer(player, player.getPosition().getLeft());
        player.setFacing(sweetRush.model.Direction.LEFT);
    }

    private void movePlayer(Player player, Position position) {
        if (getModel().isEmpty(position) && !getModel().isPlayer(position)) {
            player.setPosition(position);

            if (getModel().isCandy(position)) {
                Candy candy = getModel().getCandies().stream()
                    .filter(c -> c.getPosition().equals(position))
                    .findFirst().orElse(null);
                if (candy != null) {
                    scoreController.addCandyPoints(candy.getPoints());
                }
                getModel().collectCandy(position);
            }
        }
    }

    private void createOrDestroyWall(Player player) {
        Position front = player.getFacingPosition();
        Direction facing = player.getFacing();
        wallController.createOrDestroyWall(front, facing);
    }
}
