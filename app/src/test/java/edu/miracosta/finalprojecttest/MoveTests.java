package edu.miracosta.finalprojecttest;

import org.junit.Test;

import edu.miracosta.finalprojecttest.model.BoardPiece;
import edu.miracosta.finalprojecttest.model.Player;

import static edu.miracosta.finalprojecttest.model.BoardGame.GAME_BOARD_PIECES_TEST;
import static org.junit.Assert.*;


public class MoveTests {


    @Test
    public void testMovePlayerEast() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("E", player, GAME_BOARD_PIECES_TEST, null);

        assertEquals( player.getX(), 2);
        assertEquals( player.getY(), 1);
    }
    @Test
    public void testMovePlayerWest() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("W", player, GAME_BOARD_PIECES_TEST, null);

        assertEquals( player.getX(), 0);
        assertEquals( player.getY(), 1);
    }
    @Test
    public void testMovePlayerNorth() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("N", player, GAME_BOARD_PIECES_TEST, null);

        assertEquals( player.getX(), 1);
        assertEquals( player.getY(), 0);
    }
    @Test
    public void testMovePlayerSouth() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("S", player, GAME_BOARD_PIECES_TEST, null);

        assertEquals( player.getX(), 1);
        assertEquals( player.getY(), 2);
    }
}
