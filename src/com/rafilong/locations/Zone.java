package com.rafilong.locations;

import com.rafilong.things.objects.ItemList;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An area with items, vendors, and directions to other zones.
 */
public class Zone extends Location {
    private int x;
    private int y;

    transient List<Direction> directions = new LinkedList<>();
    Vendor vendor;
    ItemList items = new ItemList();

    public Zone(Zone other, int x, int y) {
        super(other);
        this.x = x;
        this.y = y;
    }

    public void advanceEpoch() {
        vendor.advanceEpoch();
    }

    public List<String> getInfo() {
        LinkedList<String> output = new LinkedList<>();

        output.add("You see " + this.getDescription());

        output.addAll(directions.stream()
                .map(d -> String.format("In the %s you see %s.", d.getName(), d.getZone().getName()))
                .collect(Collectors.toList()));

        if (items.size() > 0) output.add(String.format("Nearby there are %s.", getItems().toString()));

        output.add("From here, you can go: " + listDirections());

        return output;
    }

    /**
     * Returns directions in comma separated list
     *
     * @return formatted directions
     */
    public String listDirections() {
        return String.join(", ",
                directions.stream().map(Direction::getName).collect(Collectors.toList()));
    }

    public void addDirection(Direction d) {
        directions.add(d);
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public ItemList getItems() {
        return items;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
