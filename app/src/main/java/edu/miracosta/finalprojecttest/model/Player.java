package edu.miracosta.finalprojecttest.model;


import static edu.miracosta.finalprojecttest.model.BoardValues.CABN_6_2;

/**
 * Handles all Player values and contains their Inventory:
 * - xy position in GAME_BOARD_PIECES
 * - Condition, Hunger, Thirst, Temperature
 * - Handles if Player is inside or not
 */
public class Player {

    public static final int DEFAULT_X = CABN_6_2.getX();
    public static final int DEFAULT_Y = CABN_6_2.getY();
    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;


    private double condition;
    private double temperature;
    private double hunger;
    private double thirst;

    private int x;
    private int y;

    private Inventory inventory;

    public Player() {
        condition = MAX_VALUE;
        temperature = MAX_VALUE;
        hunger = MAX_VALUE;
        thirst = MAX_VALUE;
        x = DEFAULT_X;
        y = DEFAULT_Y;
        inventory = new Inventory();

    }

    /**
     * If player's xy position is equal to the xy pos of the Cabin,
     * then set isPlayerInside variable to true
     * @return
     */
    public boolean isPlayerInside() {
        if (x == DEFAULT_X && y ==DEFAULT_Y) {
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "condition=" + condition +
                ", temperature=" + temperature +
                ", hunger=" + hunger +
                ", thirst=" + thirst +
                ", x=" + x +
                ", y=" + y +
                ", isInside=" + isPlayerInside() +
                '}';
    }

    /**
     * toString for the Player's inventory
     * @return
     */
    public String displayInventory() {
        return "Inventory{" +
                "firewood=" +  inventory.getFirewood() +
                ", food=" + inventory.getFood() +
                ", water bottle=" + inventory.getWaterBottle();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getCondition() {
        return condition;
    }

    /**
     * Checks that Condition value is between 0 and 100
     * @param condition
     */
    public void setCondition(double condition) {

        if (condition < 0) {

            this.condition = 0;
        }
        else if (condition > 100) {

            this.condition = 100;
        }
        else this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    /**
     * Checks that the temperature remains between 0 and 100
     * @param temperature
     */
    public void setTemperature(double temperature) {

        if (temperature < 0) {

            this.temperature = 0;
        }
        else if (temperature > 100) {

            this.temperature = 100;
        }
        else this.temperature = temperature;
    }

    public double getHunger() {
        return hunger;
    }

    /**
     * Makes sure the hunger value stays between 0 and 100
     * @param hunger
     */
    public void setHunger(double hunger) {

        if (hunger < 0) {

            this.hunger = 0;
        }
        else if (hunger > 100) {

            this.hunger = 100;
        }
        else this.hunger = hunger;

    }

    public double getThirst() {
        return thirst;
    }

    /**
     * Makes sure the thirst value stays between 0 and 100
     * @param thirst
     */
    public void setThirst(double thirst) {

        if (thirst < 0) {

            this.thirst = 0;
        }
        else if (thirst > 100) {

            this.thirst = 100;
        }
        else this.thirst = thirst;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
