package com.rafilong.modes.game.actions;

import com.rafilong.locations.Vendor;
import com.rafilong.modes.Action;

import java.util.Collections;
import java.util.List;

public class ActionWares extends Action {
    private Vendor vendor;

    public ActionWares(Vendor v) {
        super("wares");
        this.vendor = v;
    }

    @Override
    public List<String> execute(String arg) {
        return Collections.singletonList(vendor.listWares());
    }
}
