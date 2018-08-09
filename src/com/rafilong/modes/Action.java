package com.rafilong.modes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Action {
    private List<String> names = new LinkedList<>();

    protected Action(String... names) {
        this.names.addAll(Arrays.asList(names));
    }

    public boolean matches(String cmd) {
        return names.contains(cmd.toLowerCase());
    }

    /**
     * Executed by the mode when input matches
     *
     * @param arg argument for the function
     * @return any output needed to be printed
     */
    public abstract List<String> execute(String arg);
}
