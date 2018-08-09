package com.rafilong;

import com.rafilong.modes.menu.MainMenu;

/**
 * Handles importing files from system and from the internet, as well as initializing variables.
 */
public class GameEngine {
    public static final String DIRECTORY = "src/resources/";
    public static final String WORLD_DIRECTORY = "src/resources/worlds/";
    public static final String SAVES_DIRECTORY = "src/resources/saves/";

    /**
     * Initializes the ModeGame and IO objects and begins game flow.
     *
     * @param args checks first argument for file path
     */
    public static void main(String[] args) {
        new MainMenu().start();
    }
}
