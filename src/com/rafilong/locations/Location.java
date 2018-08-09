package com.rafilong.locations;

/**
 * Abstract location class.
 */
public abstract class Location {
    private String name;
    private String description;

    public Location(Location other) {
        this.name = other.name;
        this.description = other.description;
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void advanceEpoch();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
