package com.rafilong.modes.game;

import com.rafilong.modes.Mode;
import com.rafilong.things.entities.Monster;
import com.rafilong.things.entities.Player;
import com.rafilong.modes.game.actions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ModeCombat mode between a player and a monster.
 * Mode is exited when one is dead.
 */
public class ModeCombat extends Mode {
    private Player player;
    private Monster monster;

    /**
     * Constructor from a layout.
     * Adds all duel actions.
     *
     * @param p the player
     * @param m the monster
     */
    public ModeCombat(Player p, Monster m) {
        player = p;
        monster = m;

        addExitAction(new ActionQuit());
        addExitAction(new ActionDisengage());

        addInputAction(new ActionAttack(player, monster));
        addInputAction(new ActionStatus(player, monster));
        addInputAction(new ActionList(player));
        addInputAction(new ActionInfo(player));
    }

    @Override
    protected List<String> init() {
        return Collections.singletonList("You square off against your chosen opponent, the " + monster.getName());
    }

    @Override
    protected List<String> close() {
        LinkedList<String> output = new LinkedList<>();

        output.add("You defeated the monster!");
        output.add("You gained " + monster.defeatExp() + " exp!");
        output.add("You gained " + monster.defeatGold() + " gold!");
        player.gainExp(monster.defeatExp());
        player.gainGold(monster.defeatGold());
        if (player.level()) {
            output.add("You leveled up to level " + player.getLevel() + "!");
        }

        return output;
    }

    @Override
    protected boolean isDone() {
        return !monster.isAlive() || !player.isAlive();
    }
}
