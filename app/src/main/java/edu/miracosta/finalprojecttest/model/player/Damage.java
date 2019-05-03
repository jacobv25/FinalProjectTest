package edu.miracosta.finalprojecttest.model.player;

import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.enviroment.Weather;

/**
 * Handles the calculations that determine how much damage the character takes.
 * Depends on time of day and current weather conditions.
 */
public class Damage {

    public static final double FREEZING_POINT = 32; //32 deg Fahrenheit
    public static final double DEFAULT_HUNGER_DAMAGE = 1;
    public static final double DEFAULT_CONDITION_DAMAGE = 1;
    public static final double DEFAULT_THIRST_DAMAGE = 2.5;

    /**
     *  If the Player is NOT inside,
     *  then calculate freezing damage.
     *
     *  Calculate the Player's hunger, thirst and condition damage
     *
     * @param player
     * @param weather
     * @param gameTime
     */
    public static void damagePlayer(Player player, Weather weather, GameTime gameTime) {

        weather.calculateTemp(gameTime);

        if (!player.isPlayerInside()) {
            calcTempDamage(player, weather, gameTime);
        }
            calcHungerDamage(player);
            calcThirstDamage(player);
            calcConditionDamage(player);
    }
    /**
     * If the Player's hunger, thirst or warmth reach zero, the Player's condition will begin to drop
     * @param player
     */
    private static void calcConditionDamage(Player player) {

        if (player.getTemperature() == 0) {

            player.setDisplayText("player temp is zero");
        }
        if (player.getHunger() == 0 || player.getTemperature() == 0 || player.getThirst() == 0) {

            player.setCondition(player.getCondition() - DEFAULT_CONDITION_DAMAGE);
        }
    }
    /**
     *  Checks the current weather and determines the damage to the Player's temperature.
     *  The lower the temperature, the more damage done.
     * @param player
     * @param weather
     * @param gameTime
     */
    private static void calcTempDamage(Player player, Weather weather, GameTime gameTime) {

        double freezingDamage;
        double currentPlayerTemp = player.getTemperature();

        if (weather.calculateTemp(gameTime) < FREEZING_POINT) {

            freezingDamage = FREEZING_POINT - weather.calculateTemp(gameTime);
            player.setTemperature(currentPlayerTemp - freezingDamage);
        }
    }
    /**
     * Sets the Player's hunger to what it originally was, minus DEFAULT_HUNGER_DAMAGE
     *
     * @param player
     */
    private static void calcHungerDamage(Player player) {

        double currentPlayerHunger = player.getHunger();

        player.setHunger(currentPlayerHunger - DEFAULT_HUNGER_DAMAGE);
    }
    /**
     * Sets the Player's thirst to what it was, minus DEFAULT_THIRST_DAMAGE
     *
     * @param player
     */
    private static void calcThirstDamage(Player player) {

        double currentPlayerThirst = player.getThirst();

        player.setThirst(currentPlayerThirst - DEFAULT_THIRST_DAMAGE);
    }

}
