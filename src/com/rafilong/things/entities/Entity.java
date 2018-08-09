package com.rafilong.things.entities;

import com.rafilong.things.Thing;

public class Entity extends Thing {
    double attack;
    double defense;
    double health;
    double maxHealth;

    public Entity(Entity other) {
        this.name = other.name;
        this.attack = other.attack;
        this.defense = other.defense;
        this.health = other.health;
        this.maxHealth = this.health;
    }

    public Entity(String name, double attack, double defense, double health) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = this.health;
    }

    public void attack(Entity e) {
        e.takeDamage(attack);
    }

    public void takeDamage(double dmg) {
        health -= dmg - defense;
    }

    public void takeTrueDamage(double dmg) {
        health -= dmg;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }
}
