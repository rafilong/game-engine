package com.rafilong.locations;

import com.google.gson.Gson;
import com.rafilong.things.objects.ItemGenerator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Contains physical information about current game.
 */
public class World {
    private static final double VENDOR_ZONE_RATIO = 0.2;

    private Zone[][] world;

    public World(String zoneJson, String itemJson, int width, int height) {
        world = new Zone[width][height];
        generateZones(zoneJson);
        generateVendors(itemJson);
        buildDirections();
    }

    public void advanceEpoch() {
        for (Zone[] zones : world) {
            for (Zone z : zones) {
                z.advanceEpoch();
            }
        }
    }

    private void generateZones(String json) {
        List<Zone> zones = Arrays.asList(new Gson().fromJson(json, Zone[].class));

        for (int r = 0; r < world.length; r++) {
            for (int c = 0; c < world[0].length; c++) {
                world[r][c] = new Zone(zones.get((int) (Math.random() * zones.size())), r, c);
            }
        }
    }

    private void generateVendors(String json) {
        ItemGenerator generator = new Gson().fromJson(json, ItemGenerator.class);
        int numVendors = (int) (world.length * world[0].length * VENDOR_ZONE_RATIO);

        for (int i = 0; i < numVendors; i++) {
            int x = (int) (world.length * Math.random());
            int y = (int) (world[0].length * Math.random());

            world[x][y].setVendor(new Vendor(generator));
        }
    }

    public void buildDirections() {
        for (int r = 0; r < world.length; r++) {
            for (int c = 0; c < world[0].length; c++) {
                linkZone(world[r][c]);
            }
        }
    }

    public void linkZone(Zone z) {
        z.directions = new LinkedList<>();

        int r = z.getX();
        int c = z.getY();

        if (r != 0) z.addDirection(new Direction("North", world[r - 1][c]));
        if (c != world[0].length - 1) z.addDirection(new Direction("East", world[r][c + 1]));
        if (r != world.length - 1) z.addDirection(new Direction("South", world[r + 1][c]));
        if (c != 0) z.addDirection(new Direction("West", world[r][c - 1]));
    }

    public Zone[][] getWorld() {
        return world;
    }

    public Zone getZone(Zone z) {
        return world[z.getX()][z.getY()];
    }

    public Zone getZone(int x, int y) {
        return world[x][y];
    }
}
