package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;

import java.util.Collections;
import java.util.List;

public class ActionDisengage extends Action {

    public ActionDisengage() {
        super("disengage");
    }

    @Override
    public List<String> execute(String arg) {
        return Collections.singletonList("Run away!");
    }
}
