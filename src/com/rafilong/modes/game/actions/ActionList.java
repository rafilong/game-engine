package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.things.entities.Player;

import java.util.Collections;
import java.util.List;

public class ActionList extends Action {
    private Player player;

    public ActionList(Player p) {
        super("list");
        player = p;
    }

    @Override
    public List<String> execute(String arg) {
        return Collections.singletonList("I am carrying " + player.getItems().toString());
    }
}
