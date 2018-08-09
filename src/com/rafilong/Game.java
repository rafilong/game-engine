package com.rafilong;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rafilong.locations.World;
import com.rafilong.things.entities.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Contains all information about the current game state.
 */
public class Game {
    private int time;
    private World world;
    private Player player;

    private Game(World w, Player player) {
        time = 0;
        this.world = w;
        this.player = player;
    }

    /**
     * Generates a new game from the specified directory containing information about procedural generation.
     *
     * @param path path to directory
     * @return a newly generated game
     */
    public static Game generateGame(String path) {
        try {
            String zoneJson = String.join("\n",
                    Files.readAllLines(Paths.get(GameEngine.WORLD_DIRECTORY + path + "/zones.json")));
            String itemJson = String.join("\n",
                    Files.readAllLines(Paths.get(GameEngine.WORLD_DIRECTORY + path + "/items.json")));

            World w = new World(zoneJson, itemJson, 10, 10);
            Player p = new Player("test", 0, 0, 10, w.getWorld()[0][0]);

            return new Game(w, p);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Loads a game from a given file.
     *
     * @param path the path to the file
     * @param filename the filename
     * @return the loaded game
     */
    public static Game loadGame(String path, String filename) {
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(path + filename + ".json")));
            Game g = new Gson().fromJson(json, Game.class);

            g.getWorld().buildDirections();
            g.getPlayer().setLocation(g.getWorld().getZone(g.getPlayer().getLocation()));

            return g;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Saves a game to the specified file.
     *
     * @param path the path to the file
     * @param filename the filename
     * @return whether the game was successfully saved
     */
    public boolean saveGame(String path, String filename) {
        try (Writer writer = new FileWriter(path + filename + ".json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void advanceEpoch() {
        world.advanceEpoch();
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }
}
