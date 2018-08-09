package com.rafilong.modes.menu;

import com.rafilong.Game;
import com.rafilong.GameEngine;
import com.rafilong.modes.Action;
import com.rafilong.modes.Mode;
import com.rafilong.modes.game.ModeGame;
import com.rafilong.modes.menu.actions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Mode for the menu.
 * Allows the user to create, save, load, and rejoin games.
 */
public class MainMenu extends Mode {
    private Game game;

    /**
     * Constructor from a layout.
     * Adds all menu actions.
     */
    public MainMenu() {
        addExitAction(new ActionQuit());

        addInputAction(new ActionJoin());
        addInputAction(new ActionCreate());
        addInputAction(new ActionLoad());
        addInputAction(new ActionSave());
        addInputAction(new ActionList());
    }

    @Override
    protected List<String> init() {
        return Collections.singletonList("Welcome to generic adventure game!");
    }

    @Override
    protected List<String> close() {
        return Collections.singletonList("Adios!");
    }

    @Override
    protected boolean isDone() {
        return false;
    }

    /**
     * Creates a new game.
     */
    private class ActionCreate extends Action {
        ActionCreate() {
            super("create");
        }

        @Override
        public List<String> execute(String arg) {
            game = Game.generateGame(arg);

            if (game != null) {
                return Collections.singletonList("Created game.");
            } else {
                return Collections.singletonList("ERROR: Enter a valid game directory.");
            }
        }
    }

    /**
     * Loads a game from a file.
     */
    private class ActionLoad extends Action {
        ActionLoad() {
            super("load");
        }

        @Override
        public List<String> execute(String arg) {
            game = Game.loadGame(GameEngine.SAVES_DIRECTORY, arg);

            if (game != null) {
                return Collections.singletonList("Loaded save.");
            } else {
                return Collections.singletonList("ERROR: Enter a valid save file.");
            }
        }
    }

    /**
     * Joins the currently loaded game.
     */
    private class ActionJoin extends Action {
        ActionJoin() {
            super("play", "rejoin", "continue");
        }

        @Override
        public List<String> execute(String arg) {
            LinkedList<String> output = new LinkedList<>();

            if (game == null) {
                output.add("ERROR: Game was never initialized. Create or load one.");
            } else {
                new ModeGame(game).start();
            }

            return output;
        }
    }

    /**
     * Saves the current game.
     */
    private class ActionSave extends Action {
        ActionSave() {
            super("save");
        }

        @Override
        public List<String> execute(String arg) {
            if (game.saveGame(GameEngine.SAVES_DIRECTORY, arg)) {
                return Collections.singletonList("Game saved.");
            } else {
                return Collections.singletonList("ERROR: Enter a valid file name.");
            }
        }
    }
}
