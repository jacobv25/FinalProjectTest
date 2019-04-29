package edu.miracosta.finalprojecttest.model;

import static edu.miracosta.finalprojecttest.model.StoryElements.BODY_CABIN;
import static edu.miracosta.finalprojecttest.model.StoryElements.INTRO;

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
     */
    public static BoardPiece CABN_6_2 = new BoardPiece(2, 0, 0, 0, 6, 2, false, "Dark dank cabin.");

    public static BoardPiece TRAL_5_2 = new BoardPiece(0, 0, 0, 0, 5, 2, false, "A trail going east-west.");
    public static BoardPiece TRAL_4_2 = new BoardPiece(0, 0, 0, 0, 4, 2, false, "A trail going east-west.");
    public static BoardPiece TRAL_3_2 = new BoardPiece(0, 0, 0, 0, 3, 2, false, "A trail going east-west.");

    public static BoardPiece ROAD_2_2 = new BoardPiece(0, 0, 0, 0, 2, 2, false, "A road going north-south.");
    public static BoardPiece ROAD_2_3 = new BoardPiece(0, 0, 0, 0, 2, 3, false, "A road going north-south.\n" +
                                                                                                                                "A car crash lays before you");
    public static BoardPiece ROAD_2_4 = new BoardPiece(0, 0, 0, 0, 2, 4, false, "A road going north-south.");
    public static BoardPiece ROAD_2_5 = new BoardPiece(0, 0, 0, 0, 2, 5, false, "A road going north-south.");
    public static BoardPiece ROAD_2_6 = new BoardPiece(0, 0, 0, 0, 2, 6, false, "A road going north-south.");
    public static BoardPiece ROAD_2_7 = new BoardPiece(0, 0, 0, 0, 3, 7, false, "A road going north-south.");


    public static final BoardPiece TEST_X_Y = new BoardPiece(10, 10, 10, 10, 0, 0, false, "This is start area of testing");
    public static final BoardPiece TST_STRT = new BoardPiece(0, 0, 0, 0, 1, 1, false, "This area is used for testing");
    public static final BoardPiece MOUNTAIN = new BoardPiece(0, 0, 0, 0, 0, 0, true, "Impassable mountains.");


    /**
     * These are old values that I thought we would use.
     * Hanging on to them just in case.
     */
    public final static int CLEARING = 1;
    public final static int FOREST = 2;
    public final static int RIVER = 3;
    public final static int CABIN = 4;

    /**
     * Original values from Paulding's The Escape
     */
    public final static int OBST = 1;
    public final static int FREE = 2;
    public final static int EXIT = 3;

}
