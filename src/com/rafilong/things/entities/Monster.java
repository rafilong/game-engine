package com.rafilong.things.entities;

public class Monster extends Entity {

    public Monster(Entity other) {
        super(other);
    }

    public double defeatExp() {
        return ((attack + defense) / 2 + maxHealth) * 20;
    }

    public int defeatGold() {
        return (int) defeatExp() / 2;
    }
}
