package com.rafilong.things.objects;

/**
 * A modifier to a weapon.
 * Multiple modifiers can be stacked together to form an item.
 */
public class Modifier {
    private String name;
    private double multiplier;

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
