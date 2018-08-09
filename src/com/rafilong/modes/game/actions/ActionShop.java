package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.modes.game.ModeShop;
import com.rafilong.things.entities.Player;

import java.util.LinkedList;
import java.util.List;

public class ActionShop extends Action {
    Player player;

    public ActionShop(Player p) {
        super("shop");
        this.player = p;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        if (player.getLocation().getVendor() != null) {
            new ModeShop(player, player.getLocation().getVendor()).start();
        } else {
            output.add("There is no shop here");
        }

        return output;
    }
}
