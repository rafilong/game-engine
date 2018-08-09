package com.rafilong.modes.game.actions;

import com.rafilong.things.entities.Player;
import com.rafilong.modes.Action;

import java.util.LinkedList;
import java.util.List;

public class ActionTake extends Action {
    private Player player;

    public ActionTake(Player p) {
        super("take", "grab");
        player = p;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        if (!player.take(arg)) {
            output.add("I can't take " + arg);
        }
        output.addAll(player.getLocation().getInfo());

        return output;
    }
}