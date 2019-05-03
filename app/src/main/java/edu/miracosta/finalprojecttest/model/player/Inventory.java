//package edu.miracosta.finalprojecttest.model;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import static edu.miracosta.finalprojecttest.model.player.Action.POS_FIREWOOD;
//import static edu.miracosta.finalprojecttest.model.player.Action.POS_FOOD;
//import static edu.miracosta.finalprojecttest.model.player.Action.POS_PLANTS;
//import static edu.miracosta.finalprojecttest.model.player.Action.POS_WATER_BOTTLE;
//import static edu.miracosta.finalprojecttest.model.Player.MIN_VALUE;
//
///**
// * The class handles all of the setting and getting in the Player's inventory.
// * Uses an integer array of size three to keep track of the amount of firewood, food and water
// */
//public class Inventory implements Parcelable {
//
//    public static final int MAX_INVENTORY_SPACE = 4;
//
//
//    private int firewood;
//    private int food;
//    private int water;
//    private int plants;
//
//    public Inventory(int firewood, int food, int water, int plants) {
//        this.firewood = firewood;
//        this.food = food;
//        this.water = water;
//        this.plants = plants;
//    }
//
//    public Inventory() {
//
//        firewood = 0;
//        food = 0;
//        water = 0;
//        plants = 0;
//    }
//
//    public Inventory(Inventory other) {
//
//        this.firewood = other.getFirewood();
//        this.food = other.getFood();
//        this.water = other.getWater();
//        this.plants = other.getPlants();
//    }
//
//    @Override
//    public String toString() {
//        return "Inventory{" +
//                "firewood=" + firewood +
//                ", food=" + food +
//                ", water=" + water +
//                ", plants=" + plants +
//                '}';
//    }
//
//    /**
//     * Gets the postition of plants in inventory and returns
//     * its amount
//     * @return
//     */
//    public int getPlants() {
//        return  this.plants;
//    }
//
//    /**
//     * Sets the amount of plants in inventory
//     * @param plants
//     */
//    public void setPlants( int plants) {
//        this.plants = plants;
//    }
//
//    /**
//     * Gets the position on firewood in inventory
//     * and returns its amount
//     * @return
//     */
//    public int getFirewood() {
//        return firewood;
//    }
//
//    /**
//     * Position zero in inventory is fire wood
//     * @param firewood
//     */
//    public void setFirewood(int firewood) {
//        this.firewood = firewood;
//    }
//
//    /**
//     * Gets position zero in inventory array
//     * and returns the amount of food
//     * @return
//     */
//    public int getFood() {
//        return food;
//    }
//
//    /**
//     * Sets position of food in inventory to the parameter
//     * @param food
//     */
//    public void setFood(int food) {
//        this.food = food;
//    }
//
//    /**
//     * Gets the position of water in Inventory
//     * and return its amount
//     * @return
//     */
//    public int getWater() {
//        return water;
//    }
//
//    /**
//     * Sets the ammount of water in the water position in inventory
//     * @param water
//     */
//    public void setWater(int water) {
//        this.water = water;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(firewood);
//        dest.writeInt(food);
//        dest.writeInt(water);
//        dest.writeInt(plants);
//    }
//
//    private Inventory(Parcel parcel) {
//
//        firewood = parcel.readInt();
//        food = parcel.readInt();
//        water = parcel.readInt();
//        plants = parcel.readInt();
//    }
//
//    public static final Parcelable.Creator<Inventory> CREATOR = new Creator<Inventory>() {
//        @Override
//        public Inventory createFromParcel(Parcel source) {
//            return new Inventory(source);
//        }
//
//        @Override
//        public Inventory[] newArray(int size) {
//            return new Inventory[size];
//        }
//    };
//}
