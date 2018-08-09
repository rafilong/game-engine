package com.rafilong.modes.menu.actions;

import com.rafilong.modes.Action;

import java.util.Collections;
import java.util.List;

/**
 * Quits the game.
 */
public class ActionQuit extends Action {

    public ActionQuit() {
        super("quit", "exit");
    }

    @Override
    public List<String> execute(String arg) {
        return Collections.singletonList("Exiting program.");
    }
}
