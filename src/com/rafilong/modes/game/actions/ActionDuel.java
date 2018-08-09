package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.modes.game.ModeCombat;
import com.rafilong.things.entities.Player;

import java.util.LinkedList;
import java.util.List;

public class ActionDuel extends Action {
    private Player player;

    public ActionDuel(Player p) {
        super("duel", "fight", "attack");
        player = p;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

//        if (player.getLocation().getMonster(arg).isPresent()) {
//            new ModeCombat(player, player.getLocation().getMonster(arg).get()).start();
//        } else {
            output.add("I can't duel that monster");
//        }

        return output;
    }
}
