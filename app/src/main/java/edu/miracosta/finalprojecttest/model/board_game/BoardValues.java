package edu.miracosta.finalprojecttest.model.board_game;

/**
 * This class is for organizational purposes:
 *
 * It serves to initialize the BoardPieces and give them specific values.
 *
 * As of 04/21/18, we've only created three test areas to play with
 */
public class BoardValues {

    /**
     * These are the BoardPieces that are initialized to specific values we will come up with.
     * Right now there are just simple values so we can continue to test.
     * Ideally, when we are finished there will be 15 to 25 unique areas.
     * After thinking, it may be easier/cleaner to use  database to load these values
     */

    public static final BoardPiece TEST_1_1 = new BoardPiece(10, 10, 10, 10, 1, 1,
            false, "This area is used for testing");
    public static final BoardPiece TST_STRT = new BoardPiece(0, 0, 0, 0, 1, 2,
            false, "This is the start area for testing");


}
