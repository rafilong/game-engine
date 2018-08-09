package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.things.entities.Entity;
import com.rafilong.things.entities.Monster;
import com.rafilong.things.entities.Player;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.max;

public class ActionStatus extends Action {
    private Player player;
    private Monster monster;

    public ActionStatus(Player p, Monster m) {
        super("status");
        player = p;
        monster = m;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        output.add("Player:  " + healthBar(player));
        output.add("Monster: " + healthBar(monster));

        return output;
    }

    /**
     * Prints a bar representing the percentage of max health the entity hash
     * @param e the given entity
     * @return the formatted bar
     */
    private String healthBar(Entity e) {
        return healthBar(e.getHealth(), e.getMaxHealth());
    }

    /**
     * Prints a bar representing the percentage of health
     *
     * @param health the current health
     * @param maxHealth the max health
     * @return the formatted bar
     */
    private String healthBar(double health, double maxHealth) {
        int numOfTwenty = (int) (health / maxHealth) * 20;
        numOfTwenty = max(0, numOfTwenty);

        String output = String.join("", Collections.nCopies(numOfTwenty, "#"));
        output += String.join("", Collections.nCopies(20 - numOfTwenty, "_"));

        return output;
    }
}
