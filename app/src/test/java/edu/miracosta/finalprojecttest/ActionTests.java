package edu.miracosta.finalprojecttest;

import org.junit.Test;

import edu.miracosta.finalprojecttest.model.player.Action;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.model.player.Player;

import static edu.miracosta.finalprojecttest.model.board_game.BoardGame.GAME_BOARD_PIECES_TEST;
import static org.junit.Assert.*;

/**
 * Local tests for Action.java
 **/
public class ActionTests {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void testHarvestAnimal() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.setFood(0);
        System.out.println("player food =" + player.getFood());
        BoardPiece[][] testBoard = GAME_BOARD_PIECES_TEST; //because GAME_BOARD_PIECES_TEST is final, we need a new temp board game
        Action.harvestAnimal(player, testBoard);
        assertEquals(1, player.getFood());
        assertEquals(9, testBoard[player.getX()][player.getY()].getAnimals());
    }
    @Test
    public void testPickPlant() {

        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.setPlants(0);
        BoardPiece[][] testBoard = GAME_BOARD_PIECES_TEST; //because GAME_BOARD_PIECES_TEST is final, we need a new temp board game
        Action.pickPlant(player, testBoard);
        assertEquals(1, player.getPlants());
        assertEquals(9, testBoard[player.getX()][player.getY()].getPlants());
    }

}