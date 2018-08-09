package com.rafilong.modes.game.actions;

import com.rafilong.Game;
import com.rafilong.modes.Action;

import java.util.LinkedList;
import java.util.List;

public class ActionEpoch extends Action {
    Game game;

    public ActionEpoch(Game g) {
        this.game = g;
    }

    @Override
    public List<String> execute(String arg) {
        game.advanceEpoch();
        return new LinkedList<>();
    }
}
