package edu.miracosta.finalprojecttest.model.player;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.model.enviroment.CampFire;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.player.Player;
import edu.miracosta.finalprojecttest.model.player.Regeneration;

import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.CABN_6_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_3;
import static edu.miracosta.finalprojecttest.model.StoryElements.BODY_CABIN;
import static edu.miracosta.finalprojecttest.model.StoryElements.CAR_CRASH;

/**
 * Handles all the Player Actions
 * -eating, drinking, starting fire, collect firewood
 */
public class Action {
    //TODO: Change these to string resources
    public static final String FIREWOOD_SUCCESS = "You picked up firewood.";
    public static final String FIREWOOD_FAILURE = "You could not find any firewood.";
    public static final String START_FIRE_SUCCESS = "You started a fire.";
    public static final String START_FIRE_FAILURE = "You have no wood to start a fire.";
    public static final String COLLECT_WATER_SUCCESS = "You collected water.";
    public static final String COLLECT_WATER_FAILURE = "You failed to collect any water.";
    public static final String HARVEST_FOOD_SUCCESS = "You harvested food.";
    public static final String HARVEST_FOOD_FAILURE = "You failed to harvest any food.";
    public static final String PICK_PLANT_SUCCESS = "You picked a plant.";
    public static final String PICK_PLANT_FAILURE = "You failed to pick any plants.";
    public static final String EAT_FOOD_SUCCESS = "You ate some food.";
    public static final String EAT_FOOD_FAILURE = "You have no food to eat.";
    public static final String DRINK_WATER_SUCCESS = "You drank some water.";
    public static final String DRINK_WATER_FAILURE = "You have no water to drink.";
    public static final String ENCUMBERED = "You are encumbered.";
    public static final String MTN_BLOCK_ALERT= "A steep hillside blocks your way.";

    public static final int MAX_INV_ITEMS = 7;


    /**
     * Access the xy area the Player is currently at and check the amount of firewood.
     * If the amount is greater than zero, decrement from the ammount and add it to the
     * player's firewood inventory
     * @param player
     */
    //TODO: Fix encumbered bug
    //TODO: To fix this, I'm going to work on the ListInventory
    public static void getFireWood(Player player, BoardPiece[][] boardGame) {

        int x = player.getX();
        int y = player.getY();
        int count;
        BoardPiece currentArea = boardGame[y][x];;

        if (!(currentArea.getFirewood() <= 0)) {
            //set count to the new amount of firewood
            count = player.getFirewood() + 1;
            //check if player is over encumbered
            if (player.getNumInventoryItems() + count > MAX_INV_ITEMS) {

                player.setDisplayText(ENCUMBERED);
            }
            else {
                //subtract from the currentArea
                currentArea.setFirewood(currentArea.getFirewood() - 1);
                //set the inventory to the new firewood count
                player.setFirewood(count);
                //set the player's inventory to the new inventory
                //player.setInventory(inventory);
                //set the displayText to say "You collected wood!"
                player.setDisplayText(FIREWOOD_SUCCESS);
            }
        }
        else
            player.setDisplayText(FIREWOOD_FAILURE);
    }
    /**
     * Access the xy area the Player is currently at and check the amount of food.
     * If the amount is greater than zero, decrement from the amount and add it to the
     * player's food inventory
     * @param player
     */
    public static void harvestAnimal(Player player, BoardPiece[][] boardGame) {

        int x = player.getX();
        int y = player.getY();
        int count;
        //Inventory inventory = new Inventory(player.getInventory());
        BoardPiece currentArea = boardGame[y][x];


        if (!(currentArea.getAnimals() <= 0)) {
            // New comment
            //set count to the new amount of firewood
            count = player.getFood() + 1;
            //check is player is encumbered
            if (player.getNumInventoryItems() + count > MAX_INV_ITEMS) {

                player.setDisplayText(ENCUMBERED);
            }
            else {
                //subtract from the currentArea
                currentArea.setAnimals(currentArea.getAnimals() - 1);
                //set the inventory to the new firewood count
                player.setFood(count);
                //set the player's inventory to the new inventory
                //player.setInventory(inventory);
                //set the display text
                player.setDisplayText(HARVEST_FOOD_SUCCESS);
            }
        }
        else {
            player.setDisplayText(HARVEST_FOOD_FAILURE);
        }
    }
    /**
     * Access the xy area the Player is currently at and check the amount of water.
     * If the amount is greater than zero, decrement from the amount and add it to the
     * player's water inventory
     * @param player
     */
    public static void collectWater(Player player, BoardPiece[][] gameBoard) {

        int x = player.getX();
        int y = player.getY();
        int count;
        //Inventory inventory = new Inventory(player.getInventory());
        BoardPiece currentArea = gameBoard[y][x];;

        if (!(currentArea.getWater() <= 0)) {
            //set count to the new amount of firewood
            count = player.getWater() + 1;
            //check is player is encumbered
            if (player.getNumInventoryItems() + count > MAX_INV_ITEMS) {

                player.setDisplayText(ENCUMBERED);
            }
            else {
                //subtract from the currentArea
                currentArea.setWater(currentArea.getWater() - 1);
                //set the inventory to the new firewood count
                player.setWater(count);
                //set the player's inventory to the new inventory
                //player.setInventory(inventory);
                //set the display text
                player.setDisplayText(COLLECT_WATER_SUCCESS);
            }
        }
        else {
            player.setDisplayText(COLLECT_WATER_FAILURE);
        }
    }

    /**
     * If there is food in the player's inventory, decrement from that value and
     * regenerate the player's hunger value
     * @param player
     */
    public  static void eatFood(Player player) {

        //Inventory inventory = new Inventory(player.getInventory());
        int food = player.getFood();

        if (food > 0) {

            player.setFood(food - 1);
            Regeneration.regenHunger(player);
            player.setDisplayText(EAT_FOOD_SUCCESS);
        }
        else {
            player.setDisplayText(EAT_FOOD_FAILURE);
        }
    }

    /**
     * If the player has water in their inventory, decrement from that value and
     * regen the player's thirst
     * @param player
     */
    public static void drinkWater(Player player) {

        //Inventory inventory = new Inventory(player.getInventory());
        int water = player.getWater();

        if (water > 0) {

            player.setWater(water - 1);
            Regeneration.regenThirst(player);
            player.setDisplayText(DRINK_WATER_SUCCESS);
        }
        else
            player.setDisplayText(DRINK_WATER_FAILURE);
    }

    /**
     * If the player has firewood in their inventory,
     * then create a new CampFire at that xy BoardPiece.
     * @param player
     * @param gameTime
     */
    public static void startFire(Player player, GameTime gameTime, BoardPiece[][] gameBoard) {

        //Inventory inventory = new Inventory(player.getInventory());
        int firewood = player.getFirewood();
        int x = player.getX();
        int y = player.getY();
        BoardPiece currentArea = gameBoard[y][x];

        if (firewood > 0) {

            player.setFirewood(firewood - 1);
            Regeneration.regenThirst(player);
            currentArea.setCampFire(new CampFire(gameTime));
            //set display text
            player.setDisplayText(START_FIRE_SUCCESS);
        }
        else {
            player.setDisplayText(START_FIRE_FAILURE);
            currentArea.setCampFire(null);
        }
    }
    //TODO: Write documentation
    public static void pickPlant(Player player, BoardPiece[][] gameBoard) {

        int x = player.getX();
        int y = player.getY();
        int count;
        //Inventory inventory = new Inventory(player.getInventory());
        BoardPiece currentArea = gameBoard[y][x];


        if (!(currentArea.getPlants() <= 0)) {
            //set count to the new amount of plants
            count = player.getPlants() + 1;
            //check is player is encumbered
            if (player.getNumInventoryItems() + count > MAX_INV_ITEMS) {

                player.setDisplayText(ENCUMBERED);
            }
            else {
                //subtract from the currentArea
                currentArea.setPlants(currentArea.getPlants() - 1);
                //set the inventory to the new plant count
                player.setPlants(count);
                //set the display text
                player.setDisplayText(PICK_PLANT_SUCCESS);
            }
        }
        else {
            player.setDisplayText(PICK_PLANT_FAILURE);
        }
    }

    public static void look(Player player, BoardPiece[][] gameBoard) {

        int x = player.getX();
        int y = player.getY();
        String displayText;
        BoardPiece current = gameBoard[y][x];
        BoardPiece north, south, east, west, northWest, northEast, southWest, southEast;

        //TODO: Make the design cleaner
        north = gameBoard[y-1][x];
        south = gameBoard[y+1][x];
        east = gameBoard[y][x+1];
        west = gameBoard[y][x-1];
//        northWest = gameBoard[y-1][x-1];
//        northEast = gameBoard[y-1][x+1];
//        southWest = gameBoard[y+1][x-1];
//        southEast = gameBoard[y+1][x+1];

        displayText = "{ YOU LOOKED!\n" +
                        "\tnorth=" +  lookActionHelper(north)+
                        "\tsouth=" + lookActionHelper(south) +
                        "\teast=" + lookActionHelper(east) +
                        "\twest=" + lookActionHelper(west) +
//                        "\tnorth west=" + lookActionHelper(northWest) +
//                        "\tnorth east=" + lookActionHelper(northEast) +
//                        "\tsouth west=" + lookActionHelper(southWest) +
//                        "\tsouth east=" + lookActionHelper(southEast) +
                        "}";
        player.setDisplayText(displayText);

        //TODO: Set player display to the Story Elements fo the area
        if (player.getX() == CABN_6_2.getX() && player.getY() == CABN_6_2.getY() ) {

            player.setDisplayText(BODY_CABIN);
        }
        if (player.getX() == ROAD_2_3.getX() && player.getY() == ROAD_2_3.getY() ) {

            player.setDisplayText(CAR_CRASH);
        }


    }
    //TODO: Get rid of hard coded values
    //TODO: Change to string resources
    private static String lookActionHelper(BoardPiece area) {

        StringBuilder displayText = new StringBuilder();

        if (area.isAnObstacle()) {
            return "Impassable mountains.\n";
        }
        else {
            if (area.getPlants() > 0) {
                displayText.append("Herbs in season\n");
            }
            if (area.getWater() > 0) {
                displayText.append("A rushing river\n");
            }
            if (area.getFirewood() > 0) {
                displayText.append("Firewood\n");
            }
            if (area.getAnimals() > 0) {
                displayText.append("An animal carcass\n");
            }
            return displayText.toString();
        }
    }
}
