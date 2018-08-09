package com.rafilong.modes.game.actions;

import com.rafilong.locations.Vendor;
import com.rafilong.modes.Action;
import com.rafilong.things.entities.Player;

import java.util.LinkedList;
import java.util.List;

public class ActionBuy extends Action {
    private Player player;
    private Vendor vendor;

    public ActionBuy(Player p, Vendor v) {
        super("buy", "purchase");
        this.player = p;
        this.vendor = v;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        if (vendor.getItems().get(arg).isPresent()) {
            if (player.buy(vendor.getItems().get(arg).get())) {
                output.add("You bought the " + arg);
            } else {
                output.add("You do not have the funds to buy the " + arg);
            }
        } else {
            output.add("The vendor does not have " + arg);
        }

        return output;
    }
}
