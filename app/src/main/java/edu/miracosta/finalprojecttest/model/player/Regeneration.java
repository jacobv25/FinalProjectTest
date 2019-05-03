package edu.miracosta.finalprojecttest.model.player;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

/**
 * This class handles all the Player regeneration calculations.
 * Not as complicated as Damage.java
 */
public class Regeneration {

    public static final double WARMING_POINT = 32; //32 deg Fahrenheit
    public static final double DEFAULT_HUNGER_REGEN = 10;
    public static final double DEFAULT_CONDITION_REGEN = 2;
    public static final double DEFAULT_THIRST_REGEN = 25;
    public static final double DEFAULT_CABIN_WARMTH_REGEN = 10;
    public static final double DEFAULT_FIRE_WARMTH_REGEN = 10;

    /**
     * If the Player is inside,
     * call the regenerate player inside method.
     * If the the current game board piece has an active fire,
     * then call the regenerate player from fire method.
     * @param player
     */
    public static void regeneratePlayer(Player player) {

        int x = player.getX();
        int y = player.getY();

        if (player.isPlayerInside()) {
            regenInside(player);
        }
        if (RUNNING_GAME_BOARD[y][x].getCampFire() != null) {
            regenFromFire(player);
        }

        regenCondition(player);
    }

    /**
     * Set's the player's temperature to what it was
     * plus the default cabin warmth regen value.
     * @param player
     */
    private static void regenInside(Player player) {

        player.setTemperature(player.getTemperature() + DEFAULT_CABIN_WARMTH_REGEN);

    }
    /**
     * Set's the player's condition to what it was
     * plus the default condition regen value.
     * @param player
     */
    private static void regenCondition(Player player) {

        if(player.getTemperature() > 0 && player.getThirst() > 0 && player.getHunger() > 0){

            player.setCondition(player.getCondition()  + DEFAULT_CONDITION_REGEN);
        }
    }
    /**
     * Set's the player's thirst to what it was
     * plus the default thirst regen value.
     * @param player
     */
    public static void regenThirst(Player player) {

        player.setThirst(player.getThirst()  + DEFAULT_THIRST_REGEN);
    }
    /**
     * Set's the player's hunger to what it was
     * plus the default hunger regen value.
     * @param player
     */
    public static void regenHunger(Player player) {

        player.setHunger(player.getHunger()  + DEFAULT_HUNGER_REGEN);
    }
    /**
     * Set's the player's temperature to what it was
     * plus the default fire warmth regen value.
     * @param player
     */
    private static void regenFromFire(Player player) {

        player.setTemperature(player.getTemperature() + DEFAULT_FIRE_WARMTH_REGEN);
    }
}
