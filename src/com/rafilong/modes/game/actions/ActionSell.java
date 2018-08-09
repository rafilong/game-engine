package com.rafilong.modes.game.actions;

import com.rafilong.locations.Vendor;
import com.rafilong.modes.Action;
import com.rafilong.things.entities.Player;
import com.rafilong.things.objects.Item;

import java.util.LinkedList;
import java.util.List;

public class ActionSell extends Action {
    private Player player;
    private Vendor vendor;

    public ActionSell(Player p, Vendor v) {
        super("buy", "purchase");
        this.player = p;
        this.vendor = v;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        if (player.getItems().get(arg).isPresent()) {
            Item item = player.getItems().get(arg).get();

            player.getItems().remove(item);
            player.gainGold(item.getPrice());
            vendor.getItems().add(item);

            output.add("You sold the " + arg);
        } else {
            output.add("You do not have " + arg);
        }

        return output;
    }
}
