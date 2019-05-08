package edu.miracosta.finalprojecttest.model.enviroment;

/**
 * This class will handle all the functions and calculations for a CampFire
 *
 * Right now, a new CampFire will burn indefinitely after just one single piece of wood.
 * Ideally, the fire will fade and will need to be restoked.
 *
 * In a super ideal world, the strength of warmth the fire gives will be related to the
 * CampFire's fuel level. But that may be a bit too much work to work on when there's still a ton of
 * other stuff to finish.
 */
public class CampFire {


    private int fuel;
    private boolean isEmpty;

    /**
     * Creates a new CampFire that will warm the player
     * @param gameTime
     */
    public CampFire(GameTime gameTime) {

        fuel = 10;      // 1 firewood cost = 10 fuel
        isEmpty = false;
    }

    public void burn() {

        fuel = fuel - 1;
    }

    public void stoke() {

        fuel = fuel + 5;
    }

    @Override
    public String toString() {
        return "CampFire{" +
                "fuel=" + fuel +
                '}';
    }

    /////////Setters & Getters/////////
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

}
