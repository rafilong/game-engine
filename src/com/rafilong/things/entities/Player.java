package com.rafilong.things.entities;

import com.rafilong.locations.Zone;
import com.rafilong.things.objects.Item;
import com.rafilong.things.objects.ItemList;
import com.rafilong.locations.Direction;
import com.rafilong.things.objects.Weapon;

import java.util.LinkedList;
import java.util.List;

/**
 * Player object with inventory and current location. Handles actions.
 */
public class Player extends Entity {
    private Zone location;
    private ItemList items;

    private int level;
    private double exp;
    private int gold;

    public Player(String name, double attack, double defense, double health, Zone location) {
        super(name, attack, defense, health);
        this.location = location;
        this.items = new ItemList();
        this.level = 0;
        this.exp = 0;
    }

    /**
     * Sets current location
     * @param l the current room
     */
    public void setLocation(Zone l) {
        this.location = l;
    }

    /**
     * Attack with an item
     *
     * @param e entity to attack
     * @param w item to deal damage with
     */
    public void attack(Entity e, Weapon w) {
        e.takeDamage(getAttack() + w.getDamage());
    }

    /**
     * Checks if the player can level up, levels up stats if so.
     *
     * @return whether the player leveled up
     */
    public boolean level() {
        final double HEALTH_MULTIPLIER = 1.3;
        final double ATTACK_MULTIPLIER = 1.5;
        final double DEFENSE_MULTIPLIER = 1.5;

        if (exp >= requiredExp()) {
            level++;

            maxHealth *= HEALTH_MULTIPLIER;
            attack *= ATTACK_MULTIPLIER;
            defense *= DEFENSE_MULTIPLIER;

            health = maxHealth;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gain gold
     *
     * @param gold amount of gold to be gained
     */
    public void gainGold(int gold) {
        this.gold += gold;
    }

    /**
     * Lose gold
     *
     * @param gold amount of gold to be lost
     */
    public void loseGold(int gold) {
        this.gold += gold;
    }

    /**
     * Checks if the item can be purchased
     */
    public boolean buy(Item i) {
        if(i.getPrice() < gold) {
            items.add(i);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gain exp
     *
     * @param exp amount of exp to be gained
     */
    public void gainExp(double exp) {
        this.exp += exp;
    }

    /**
     * Finds the required exp to reach the next level.
     *
     * @return the required exp to reach level + 1
     */
    private double requiredExp() {
        return requiredExp(level + 1);
    }

    /**
     * Finds the required exp to reach the given level.
     *
     * @param level the given level
     * @return the exp required
     */
    private double requiredExp(int level) {
        final double LEVEL_1 = 25;
        final double LEVEL_2 = 50;

        if (level == 1) {
            return LEVEL_1;
        } else if (level == 2) {
            return LEVEL_2;
        } else {
            return (requiredExp(level - 1) + requiredExp(level - 2)) * 1.1;
        }
    }

    /**
     * Attempts to move player in direction.
     *
     * @param direction direction to move player
     * @return if move was successful
     */
    public boolean go(String direction) {
        for (Direction d : location.getDirections()) {
            if (direction.equalsIgnoreCase(d.getName())) {
                location = d.getZone();
                return true;
            }
        }

        return false;
    }

    /**
     * Attempts to take item from the current room.
     *
     * @param arg item
     * @return whether the item was successfully taken
     */
    public boolean take(String arg) {
        return location.getItems().moveTo(arg, items);
    }

    /**
     * Attempts to item from inventory to the room.
     *
     * @param arg item
     * @return whether the item was successfully dropped
     */
    public boolean drop(String arg) {
        return items.moveTo(arg, location.getItems());
    }

    /**
     * Returns information about the player's stats
     * @return information about player stats
     */
    public List<String> getInfo() {
        List<String> output = new LinkedList<>();

        output.add("Level: " + level);
        output.add("Gold: " + gold);
        output.add("Health: " + health + "/" + maxHealth);
        output.add("Attack: " + attack);
        output.add("Defense: " + defense);

        return output;
    }

    public Zone getLocation() {
        return location;
    }

    public ItemList getItems() {
        return items;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }
}
