package com.rafilong.things.objects;

import com.rafilong.things.Thing;

/**
 * Generic item. Has name and damage value.
 */
public class Item extends Thing {
    private int price;

    public Item(Item item) {
        this(item.getName(), item.getPrice());
    }

    public Item(String name) {
        this(name, 0);
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, price);
    }
}
