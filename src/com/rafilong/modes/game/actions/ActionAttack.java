package com.rafilong.modes.game.actions;

import com.rafilong.modes.Action;
import com.rafilong.things.entities.Monster;
import com.rafilong.things.entities.Player;

import java.util.LinkedList;
import java.util.List;

public class ActionAttack extends Action {
    private Player player;
    private Monster monster;

    public ActionAttack(Player p , Monster m) {
        super("attack", "hit");
        player = p;
        monster = m;
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();

        if (arg.equalsIgnoreCase("")) {
            player.attack(monster);
            output.add("I viciously attack the " + monster.getName());
        } else if (player.getItems().getWeapon(arg).isPresent()){
            player.attack(monster, player.getItems().getWeapon(arg).get());
            output.add("I hit the " + monster.getName() + " with my " + arg);
        } else {
            output.add("I am not carrying " + arg);
            return output;
        }

        monster.attack(player);
        output.add("The " + monster.getName() + " counterattacks");


        return output;
    }
}
