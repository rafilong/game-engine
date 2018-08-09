package com.rafilong.modes.game;

import com.rafilong.locations.Vendor;
import com.rafilong.modes.Mode;
import com.rafilong.modes.game.actions.*;
import com.rafilong.things.entities.Player;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ModeShop extends Mode {
    private Player player;
    private Vendor vendor;

    public ModeShop(Player p, Vendor v) {
        this.player = p;
        this.vendor = v;

        addExitAction(new ActionQuit());

        addInputAction(new ActionWares(v));
        addInputAction(new ActionBuy(p, v));
        addInputAction(new ActionSell(p, v));
    }

    @Override
    protected List<String> init() {
        LinkedList<String> output = new LinkedList<>();

        output.add("You enter the store. The shopkeeper spreads his wares.");
        output.add(vendor.listWares());

        return output;
    }

    @Override
    protected List<String> close() {
        return Collections.singletonList("'Thank you for shopping!'");
    }

    @Override
    protected boolean isDone() {
        return false;
    }
}
