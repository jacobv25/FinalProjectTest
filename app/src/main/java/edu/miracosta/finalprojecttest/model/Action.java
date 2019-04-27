package edu.miracosta.finalprojecttest.model;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

/**
 * Handles all the Player Actions
 * -eating, drinking, starting fire, collect firewood
 */
public class Action {

    public static final String FIREWOOD_SUCCESS = "You picked up firewood.";
    public static final String FIREWOOD_FAILURE = "You could not find any firewood.";
    public static final String START_FIRE_SUCCESS = "You started a fire.";
    public static final String START_FIRE_FAILURE = "You have no wood to start a fire.";
    public static final String COLLECT_WATER_SUCCESS = "You collected water.";
    public static final String COLLECT_WATER_FAILURE = "You failed to collect any water.";
    public static final String HARVEST_FOOD_SUCCESS = "You harvested food.";
    public static final String HARVEST_FOOD_FAILURE = "You failed to harvest any food.";
    public static final String EAT_FOOD_SUCCESS = "You ate some food.";
    public static final String EAT_FOOD_FAILURE = "You have no food to eat.";
    public static final String DRINK_WATER_SUCCESS = "You drank some water.";
    public static final String DRINK_WATER_FAILURE = "You have no water to drink.";

    public static final int POS_FIREWOOD = 0;
    public static final int POS_FOOD = 1;
    public static final int POS_WATER_BOTTLE = 2;
    public static final int POS_PLANTS = 3;

    /**
     * Access the xy area the Player is currently at and check the amount of firewood.
     * If the amount is greater than zero, decrement from the ammount and add it to the
     * player's firewood inventory
     * @param player
     */
    public static void getFireWood(Player player, String displayText, BoardPiece[][] boardGame) {

        int x = player.getX();
        int y = player.getY();
        int count;
        Inventory inventory = player.getInventory();
        BoardPiece currentArea = boardGame[y][x];;

        if (!(currentArea.getFirewood() <= 0)) {
            //set count to the new amount of firewood
            count = inventory.getFirewood() + 1;
            //subtract from the currentArea
            currentArea.setFirewood(currentArea.getFirewood() - 1);
            //set the inventory to the new firewood count
            inventory.setFirewood(count);
            //set the player's inventory to the new inventory
            player.setInventory(inventory);
            //set the displayText to say "You collected wood!"
            displayText = FIREWOOD_SUCCESS;
        }
        else
            displayText = FIREWOOD_FAILURE;
    }
    /**
     * Access the xy area the Player is currently at and check the amount of food.
     * If the amount is greater than zero, decrement from the amount and add it to the
     * player's food inventory
     * @param player
     */
    public static void harvestAnimal(Player player, String displayText, BoardPiece[][] boardGame) {

        int x = player.getX();
        int y = player.getY();
        int count;
        Inventory inventory = player.getInventory();
        BoardPiece currentArea = boardGame[y][x];;

        if (!(currentArea.getAnimals() <= 0)) {
            // New comment
            //set count to the new amount of firewood
            count = inventory.getFood() + 1;
            //subtract from the currentArea
            currentArea.setAnimals(currentArea.getAnimals() - 1);
            //set the inventory to the new firewood count
            inventory.setFood(count);
            //set the player's inventory to the new inventory
            player.setInventory(inventory);
            //set the display text
            displayText = HARVEST_FOOD_SUCCESS;
        }
        else {
            displayText = HARVEST_FOOD_FAILURE;
        }
    }
    /**
     * Access the xy area the Player is currently at and check the amount of water.
     * If the amount is greater than zero, decrement from the amount and add it to the
     * player's water inventory
     * @param player
     */
    public static void collectWater(Player player, String displayText) {

        int x = player.getX();
        int y = player.getY();
        int count;
        Inventory inventory = player.getInventory();
        BoardPiece currentArea = RUNNING_GAME_BOARD[y][x];;

        if (!(currentArea.getWater() <= 0)) {
            //set count to the new amount of firewood
            count = inventory.getWaterBottle() + 1;
            //subtract from the currentArea
            currentArea.setWater(currentArea.getWater() - 1);
            //set the inventory to the new firewood count
            inventory.setWaterBottle(count);
            //set the player's inventory to the new inventory
            player.setInventory(inventory);
            //set the display text
            displayText = COLLECT_WATER_SUCCESS;
        }
        else {
            displayText = COLLECT_WATER_FAILURE;
        }
    }

    /**
     * If there is food in the player's inventory, decrement from that value and
     * regenerate the player's hunger value
     * @param player
     */
    public  static void eatFood(Player player, String displayText) {

        Inventory inventory = player.getInventory();
        int food = inventory.getFood();

        if (food > 0) {

            inventory.setFood(food - 1);
            Regeneration.regenHunger(player);
            displayText = EAT_FOOD_SUCCESS;
        }
        else {
            displayText = EAT_FOOD_FAILURE;
        }
    }

    /**
     * If the player has water in their inventory, decrement from that value and
     * regen the player's thirst
     * @param player
     */
    public static void drinkWater(Player player, String displayText) {

        Inventory inventory = player.getInventory();
        int water = inventory.getWaterBottle();

        if (water > 0) {

            inventory.setWaterBottle(water - 1);
            Regeneration.regenThirst(player);
            displayText = DRINK_WATER_SUCCESS;
        }
        else
            displayText = DRINK_WATER_FAILURE;
    }

    /**
     * If the player has firewood in their inventory,
     * then create a new CampFire at that xy BoardPiece.
     * @param player
     * @param gameTime
     */
    public static void startFire(Player player, GameTime gameTime, String displayText) {

        Inventory inventory = player.getInventory();
        int firewood = inventory.getFirewood();
        int x = player.getX();
        int y = player.getY();
        BoardPiece currentArea = RUNNING_GAME_BOARD[y][x];

        if (firewood > 0) {

            inventory.setFirewood(firewood - 1);
            Regeneration.regenThirst(player);
            currentArea.setCampFire(new CampFire(gameTime));
            //set display text
            displayText = START_FIRE_SUCCESS;
        }
        else {
            displayText = START_FIRE_FAILURE;
            currentArea.setCampFire(null);
        }
    }
    //TODO: Implement pick plant action
    public static void pickPlant(Player player, Object o, BoardPiece[][] testBoard) {
    }
}
