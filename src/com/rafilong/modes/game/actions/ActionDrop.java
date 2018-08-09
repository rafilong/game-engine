package com.rafilong.modes.game.actions;

import com.rafilong.things.entities.Player;
import com.rafilong.modes.Action;
import java.util.LinkedList;
import java.util.List;

public class ActionDrop extends Action {
    private Player player;

    public ActionDrop(Player p) {
        super("drop", "toss");
        player = p;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        if (!player.drop(arg)) {
            output.add("I can't drop " + arg);
        }
        output.addAll(player.getLocation().getInfo());

        return output;
    }
}