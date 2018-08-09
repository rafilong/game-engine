package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.things.entities.Player;

import java.util.List;

public class ActionInfo extends Action {
    private Player player;

    public ActionInfo(Player p) {
        super("playerinfo", "info");
        player = p;
    }

    @Override
    public List<String> execute(String arg) {
        return player.getInfo();
    }
}
