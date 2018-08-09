package com.rafilong.modes.game;

import com.rafilong.Game;
import com.rafilong.modes.Mode;
import com.rafilong.things.entities.Player;
import com.rafilong.modes.game.actions.*;

import java.util.Collections;
import java.util.List;

/**
 * ModeGame contains a locations and a player.
 */
public class ModeGame extends Mode {
    private Game game;
    private Player player;

    /**
     * Constructor from a layout.
     * Adds all adventure actions.
     *
     * @param g game object
     */
    public ModeGame(Game g) {
        this.game = g;
        this.player = g.getPlayer();

        addExitAction(new ActionQuit());

        addInputAction(new ActionGo(player));
        addInputAction(new ActionList(player));
        addInputAction(new ActionInfo(player));
        addInputAction(new ActionDuel(player));
        addInputAction(new ActionShop(player));
        addInputAction(new ActionDrop(player));
        addInputAction(new ActionTake(player));

        addCycleAction(new ActionEpoch(game));
    }

    @Override
    protected List<String> init() {
        return player.getLocation().getInfo();
    }

    @Override
    protected List<String> close() {
        if (player.isAlive()) {
            return Collections.singletonList("See you next time!");
        } else {
            return Collections.singletonList("YOU DIED");
        }
    }

    @Override
    protected boolean isDone() {
        return !player.isAlive();
    }

    public Player getPlayer() {
        return player;
    }
}
