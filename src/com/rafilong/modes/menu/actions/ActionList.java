package com.rafilong.modes.menu.actions;

import com.rafilong.GameEngine;
import com.rafilong.modes.Action;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lists the current save files.
 */
public class ActionList extends Action {

    public ActionList() {
        super("list");
    }

    @Override
    public List<String> execute(String arg) {
        LinkedList<String> output = new LinkedList<>();
        File[] files = new File(GameEngine.SAVES_DIRECTORY).listFiles();

        if (files == null || files.length == 0) {
            output.add("There are no saves.");
        } else {
            output.add("You have the following save files: ");
            output.add(String.join(", ", Arrays.stream(files).map(File::getName).collect(Collectors.toList())));
        }

        return output;
    }
}
