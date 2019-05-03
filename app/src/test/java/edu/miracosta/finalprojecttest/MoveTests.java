package edu.miracosta.finalprojecttest;

import org.junit.Test;

import edu.miracosta.finalprojecttest.model.player.Player;

import static edu.miracosta.finalprojecttest.model.board_game.BoardGame.GAME_BOARD_PIECES_TEST;
import static org.junit.Assert.*;


public class MoveTests {


    @Test
    public void testMovePlayerEast() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("E", player, GAME_BOARD_PIECES_TEST);

        assertEquals( 2, player.getX());
        assertEquals( 1, player.getY());
    }
    @Test
    public void testMovePlayerWest() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("W", player, GAME_BOARD_PIECES_TEST);

        assertEquals( 0, player.getX());
        assertEquals( 1, player.getY());
    }
    @Test
    public void testMovePlayerNorth() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("N", player, GAME_BOARD_PIECES_TEST);

        assertEquals( 1, player.getX());
        assertEquals( 0, player.getY());
    }
    @Test
    public void testMovePlayerSouth() {
        Player player = new Player();
        player.setX(1);
        player.setY(1);
        player.movePlayerBoardPiece("S", player, GAME_BOARD_PIECES_TEST);

        assertEquals( 1, player.getX());
        assertEquals( 2, player.getY());
    }
}
