package com.rafilong.things.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ItemList class to provide better search, retrieval, and toString functionality.
 */
public class ItemList extends LinkedList<Item> {

    /**
     * Gets string that matches input, ignoring case.
     *
     * @param arg search term
     * @return output Optional object
     */
    public Optional<Item> get(String arg) {
        return this.stream().filter(i -> i.getName().equalsIgnoreCase(arg)).findFirst();
    }

    /**
     * Gets string that matches input, ignoring case, and filtering for weapons.
     *
     * @param arg search term
     * @return output Optional object
     */
    public Optional<Weapon> getWeapon(String arg) {
        return this.stream().filter(Weapon.class::isInstance).map(Weapon.class::cast)
                .filter(i -> i.getName().equalsIgnoreCase(arg)).findFirst();
    }

    /**
     * Checks if the list contains the item, ignoring case.
     *
     * @param item search term
     * @return if the list contains the item
     */
    public boolean contains(String item) {
        return this.stream().anyMatch(i -> i.getName().equalsIgnoreCase(item));
    }

    /**
     * Switches item between two item lists.
     *
     * @param arg item to switch
     * @param to ItemList to move to
     * @return whether the item was moved
     */
    public boolean moveTo(String arg, ItemList to) {
        Optional<Item> item = this.get(arg);

        if (item.isPresent()) {
            this.remove(item.get());
            to.add(item.get());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a list of item names.
     *
     * @return a list of item names
     */
    private List<String> getNameList() {
        return this.stream().map(Item::toString).collect(Collectors.toList());
    }

    /**
     * Formats the list into comma separated with and between final two arguments.
     *
     * @return formatted list
     */
    @Override
    public String toString() {
        if (this.size() == 0) {
            return "nothing";
        } else if (this.size() == 1) {
            return String.join("", getNameList());
        } else if (this.size() == 2) {
            return String.join(" and ", getNameList());
        } else {
            return String.join(", and ",
                    String.join(", ", getNameList().subList(0, size() - 1)),
                    getNameList().get(size() - 1));
        }
    }
}
