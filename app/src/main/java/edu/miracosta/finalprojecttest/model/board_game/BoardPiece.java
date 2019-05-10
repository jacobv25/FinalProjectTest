package edu.miracosta.finalprojecttest.model.board_game;

import edu.miracosta.finalprojecttest.model.enviroment.CampFire;

/**
 * This class handles as the values in a BoardPiece
 * -its x and y position on the game board
 * -its quantity of resources (firewood, animals, water)
 * -weather its an obstacle or not
 * -Keeps if it has a burning camp fire
 */

public class BoardPiece {

    private int firewood;
    private int animals;
    private int water;
    private int plants;

    private int x;
    private int y;

    private String displayText;

    private boolean isAnObstacle;
    private boolean isWarmLocation;

    private CampFire campFire;

    /**
     * Full Constructor
     * campFire is set to null because initially there will
     * be no campfires until a player makes one.
     * @param firewood
     * @param water
     * @param animals
     * @param plants
     * @param x
     * @param y
     * @param isAnObstacle
     * @param isWarmLocation
     */
    public BoardPiece(int firewood, int animals, int water, int plants, int x, int y,
                      boolean isAnObstacle, boolean isWarmLocation, String displayText) {
        this.firewood = firewood;
        this.animals = animals;
        this.water = water;
        this.plants = plants;
        this.x = x;
        this.y = y;
        this.isAnObstacle = isAnObstacle;
        this.isWarmLocation = isWarmLocation;
        this.displayText = displayText;
        this.campFire = null;
    }


    @Override
    public String toString() {
        return "BoardPiece{" +
                "firewood=" + firewood +
                ", animals=" + animals +
                ", water=" + water +
                ", plants=" + plants +
                ", x=" + x +
                ", y=" + y +
                ", isAnObstacle=" + isAnObstacle +
                ", isWarmLocation=" + isWarmLocation +
                ", campFire=" + hasCampfire() +
                ", displayText=" + displayText +
                '}';
    }

    /**
     * A null value indicated there are no active campfires in this area
     * @return
     */
    public boolean hasCampfire() {

        if (campFire == null) {
            return false;
        }
        else return true;
    }

    /**
     * If there is a campfire burning, it updates it
     */
    public void update() {

        if (campFire != null) {

            campFire.burn();

            if (campFire.getFuel() == 0) {

                campFire = null;
            }
        }
     }

    //////////Getters & Setters//////////

    public CampFire getCampFire() {
        return campFire;
    }

    public void setCampFire(CampFire campFire) {
        this.campFire = campFire;
    }

    public boolean isWarmLocation() {
        return isWarmLocation;
    }

    public void setWarmLocation(boolean warmLocation) {
        isWarmLocation = warmLocation;
    }

    public boolean isAnObstacle() {
        return isAnObstacle;
    }

    public void setAnObstacle(boolean anObstacle) {
        isAnObstacle = anObstacle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFirewood() {
        return firewood;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public int getAnimals() {
        return animals;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getPlants() {
        return plants;
    }

    public void setPlants(int plants) {
        this.plants = plants;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
