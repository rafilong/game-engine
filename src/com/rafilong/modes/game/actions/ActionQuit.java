package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;

import java.util.Collections;
import java.util.List;

public class ActionQuit extends Action {

    public ActionQuit() {
        super("quit", "exit", "leave");
    }

    @Override
    public List<String> execute(String arg) {
        return Collections.singletonList("Leaving game.");
    }
}
