package com.rafilong.locations;

/**
 * Connects two zones together.
 */
public class Direction {
    private String name;
    private Zone zone;

    public Direction(String name, Zone zone) {
        this.name = name;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public Zone getZone() {
        return zone;
    }
}
