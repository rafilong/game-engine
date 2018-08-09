package com.rafilong.modes;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Mode of the game.
 *
 * Mode keeps track of a set of actions, taking user input and calling the appropriate action. Cleans up on exit
 * and at end of cycle.
 */
public abstract class Mode {
    private List<Action> inputActions = new LinkedList<>();
    private List<Action> exitActions = new LinkedList<>();
    private List<Action> cycleActions = new LinkedList<>();

    private boolean exit = false;

    /**
     * Called to begin the Mode, exits when mode finish conditions are met
     */
    public void start() {
        System.out.println(String.join("\n", init()));

        Scanner sc = new Scanner(System.in);

        while(!isDone() && !exit) {
            System.out.println(String.join("\n", cycle(sc.nextLine())));
        }

        System.out.println(String.join("\n", close()));
    }

    /**
     * Allows users to add input actions. Input actions have parameters passed to them and are searched for on input.
     * Meant for use on object initialization.
     *
     * @param a action
     */
    protected void addInputAction(Action a) {
        inputActions.add(a);
    }

    /**
     * Allows users to add input actions. Input actions do not have parameters passed to them.
     * When an exit action is found the Mode is terminated, irrespective of given exit condition.
     *
     * Meant for use on object initialization.
     *
     * @param a action
     */
    protected void addExitAction(Action a) {
        exitActions.add(a);
    }

    /**
     * Called at the end of each cycle.
     *
     * @param a action
     */
    protected void addCycleAction(Action a) {
        cycleActions.add(a);
    }

    /**
     * Runs once at beginning of start of mode. Can include flavor text / transition from previous mode.
     */
    protected abstract List<String> init();

    /**
     * Called repeatedly by the start function until the exit condition is met.
     *
     * @param input user inpput
     * @return the output to print, each entry separated by newline
     */
    private List<String> cycle(String input) {
        List<String> output = new LinkedList<>();

        String cmd = input.split("\\s+")[0];
        String arg = input.substring(input.indexOf(" ") + 1);

        for (Action action : exitActions) {
            if (action.matches(cmd)) {
                exit = true;
                output.addAll(action.execute(arg));
                return output;
            }
        }

        for (Action action : inputActions) {
            if (action.matches(cmd)) {
                output.addAll(action.execute(arg));
                return output;
            }
        }

        for (Action action : cycleActions) {
            action.execute("");
        }

        output.add("I don't understand '" + input + "'");
        return output;
    }

    /**
     * Called at the close of the mode.
     *
     * @return the output to print, each entry separated by newline
     */
    protected abstract List<String> close();

    /**
     * Exits the mode when the return is true
     *
     * @return whether the mode is done
     */
    protected abstract boolean isDone();
}
