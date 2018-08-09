package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.things.entities.Player;

import java.util.LinkedList;
import java.util.List;

public class ActionGo extends Action {
    private Player player;

    public ActionGo(Player p) {
        super("go", "run", "move", "skip");
        player = p;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        // TODO: refactor for different types of locations (shopping, looting, etc)
        if (!player.go(arg)) {
            output.add("I can't go " + arg);
        }
        output.addAll(player.getLocation().getInfo());

        return output;
    }
}
