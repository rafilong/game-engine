package com.rafilong.locations;

import com.rafilong.things.objects.ItemGenerator;
import com.rafilong.things.objects.ItemList;

/**
 * Allows players to buy and sell items.
 * Items are updated on new epochs randomly.
 */
public class Vendor extends Location {
    private static final double INVENTORY_CHANGE_CHANCE = 0.1;
    private static final double MAX_START_INVENTORY = 10;

    private transient ItemGenerator generator;
    private ItemList items;

    public Vendor(ItemGenerator g) {
        this(g, (int) (Math.random() * MAX_START_INVENTORY));
    }

    public Vendor(ItemGenerator g, int inventorySize) {
        super("Armory", "a place to buy some weapons.");
        this.generator = g;

        generateItems(inventorySize);
    }

    private void generateItems(int n) {
        items = new ItemList();
        for (int i = 0; i < n; i++) {
            items.add(generator.generateWeapon());
        }
    }

    @Override
    public void advanceEpoch() {
        if (Math.random() < INVENTORY_CHANGE_CHANCE) {
            items.remove((int) (Math.random() * items.size()));
        }

        if (Math.random() < INVENTORY_CHANGE_CHANCE) {
            items.add(generator.generateWeapon());
        }
    }

    public String listWares() {
        return String.format("I currently have %s in stock", items.toString());
    }

    public ItemList getItems() {
        return items;
    }
}
