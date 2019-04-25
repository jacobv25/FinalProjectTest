package edu.miracosta.finalprojecttest.model;

/**
 * This class handles as the values in a BoardPiece
 * -its x and y position on the game board
 * -its quantity of resources (firewood, food, water)
 * -weather its an obstacle or not
 * -Keeps if it has a burning camp fire
 */
public class BoardPiece {

    private int[] resources;
    private int firewood;
    private int food;
    private int water;

    private int x;
    private int y;

    private String displayText;

    private boolean isAnObstacle;
    private CampFire campFire;

    /**
     * Full Constructor
     * campFire is set to null because initially there will
     * be no campfires until a player makes one.
     * @param firewood
     * @param water
     * @param food
     * @param x
     * @param y
     * @param isAnObstacle
     */
    public BoardPiece(int firewood, int food, int water, int x, int y,
                      boolean isAnObstacle, String displayText) {
        this.firewood = firewood;
        this.food = food;
        this.water = water;
        this.x = x;
        this.y = y;
        this.isAnObstacle = isAnObstacle;
        this.displayText = displayText;
        this.campFire = null;
    }


    @Override
    public String toString() {
        return "BoardPiece{" +
                "firewood=" + firewood +
                ", food=" + food +
                ", water=" + water +
                ", x=" + x +
                ", y=" + y +
                ", isAnObstacle=" + isAnObstacle +
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

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
