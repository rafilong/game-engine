package com.rafilong.things.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creates items from a set of modifiers.
 */
public class ItemGenerator {
    private Modifier[] adjectives;
    private Modifier[] materials;
    private Modifier[] nouns;

    public ItemGenerator(Modifier[] adjectives, Modifier[] materials, Modifier[] nouns) {
        this.adjectives = adjectives;
        this.materials = materials;
        this.nouns = nouns;
    }

    private List<Modifier> generateModifiers() {
        List<Modifier> mods = new ArrayList<Modifier>();

        mods.add(adjectives[(int) (adjectives.length * Math.random())]);
        mods.add(materials[(int) (materials.length * Math.random())]);
        mods.add(nouns[(int) (nouns.length * Math.random())]);

        return mods;
    }

    public Item generateItem() {
        List<Modifier> mods = generateModifiers();

        String name = String.join(" ", mods.stream().map(Modifier::getName).collect(Collectors.toList()));
        int price = mods.stream().map(Modifier::getMultiplier).reduce(10.0, (a, b) -> a * b).intValue();
        return new Item(name, price);
    }

    public Weapon generateWeapon() {
        List<Modifier> mods = generateModifiers();

        String name = String.join(" ", mods.stream().map(Modifier::getName).collect(Collectors.toList()));
        int price = mods.stream().map(Modifier::getMultiplier).reduce(10.0, (a, b) -> a * b).intValue();
        int damage = mods.stream().map(Modifier::getMultiplier).reduce(1.0, (a, b) -> a * b).intValue();
        return new Weapon(name, price, damage);
    }
}
