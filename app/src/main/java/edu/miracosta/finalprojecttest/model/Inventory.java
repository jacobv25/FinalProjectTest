package edu.miracosta.finalprojecttest.model;

import static edu.miracosta.finalprojecttest.model.Action.POS_FIREWOOD;
import static edu.miracosta.finalprojecttest.model.Action.POS_FOOD;
import static edu.miracosta.finalprojecttest.model.Action.POS_WATER_BOTTLE;
import static edu.miracosta.finalprojecttest.model.Player.MIN_VALUE;

/**
 * The class handles all of the setting and getting in the Player's inventory.
 * Uses an integer array of size three to keep track of the amount of firewood, food and water
 */
public class Inventory {

    public static final int MAX_INVENTORY_SPACE = 3;


    private int[] inventory;

    public Inventory(int firewood, int food, int waterBottle) {
        inventory = new int[MAX_INVENTORY_SPACE];
        inventory[POS_FIREWOOD] = firewood;
        inventory[POS_FOOD] = food;
        inventory[POS_WATER_BOTTLE] = waterBottle;
    }

    public Inventory() {
        inventory = new int[MAX_INVENTORY_SPACE];
        inventory[POS_FIREWOOD] = MIN_VALUE;
        inventory[POS_FOOD] = MIN_VALUE;
        inventory[POS_WATER_BOTTLE] = MIN_VALUE;
    }

    public int[] getInventory() {
        return inventory;
    }

    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets the position on firewood in inventory
     * and returns its ammount
     * @return
     */
    public int getFirewood() {
        return inventory[POS_FIREWOOD];
    }

    /**
     * Position zero in inventory is fire wood
     * @param firewood
     */
    public void setFirewood(int firewood) {
        this.inventory[POS_FIREWOOD] = firewood;
    }

    /**
     * Gets position zero in inventory array
     * and returns the amount of food
     * @return
     */
    public int getFood() {
        return inventory[POS_FOOD];
    }

    /**
     * Sets position of food in inventory to the parameter
     * @param food
     */
    public void setFood(int food) {
        this.inventory[POS_FOOD] = food;
    }

    /**
     * Gets the position of water in Inventory
     * and return its amount
     * @return
     */
    public int getWaterBottle() {
        return inventory[POS_WATER_BOTTLE];
    }

    /**
     * Sets the ammount of water in the water position in inventory
     * @param waterBottle
     */
    public void setWaterBottle(int waterBottle) {
        this.inventory[POS_WATER_BOTTLE] = waterBottle;
    }
}
