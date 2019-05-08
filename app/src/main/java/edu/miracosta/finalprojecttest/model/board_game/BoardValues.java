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
    public static BoardPiece FNSH_1_6 = new BoardPiece(0, 0, 0, 0, 1, 6,
            false, "A cave that cuts through the mountains to a small town.");
    public static BoardPiece ROAD_2_2 = new BoardPiece(0, 0, 0, 0, 2, 2,
            false, "A road going north-south.\nA trail cuts east through the woods.");
    public static BoardPiece ROAD_2_3 = new BoardPiece(0, 0, 0, 0, 2, 3,
            false, "A road going north-south.\nA car crash lays before you");
    public static BoardPiece ROAD_2_4 = new BoardPiece(0, 0, 0, 0, 2, 4,
            false, "A road going north-south.");
    public static BoardPiece ROAD_2_5 = new BoardPiece(0, 0, 0, 0, 2, 5,
            false, "A road going north-south.");
    public static BoardPiece ROAD_2_6 = new BoardPiece(0, 0, 0, 0, 2, 6,
            false, "A road going north-south.");
    public static BoardPiece TRAL_3_2 = new BoardPiece(0, 0, 0, 0, 3, 2,
            false, "A trail going east-west.\nA road winds to your west.");
    public static BoardPiece TRAL_4_2 = new BoardPiece(0, 0, 0, 0, 4, 2,
            false, "A trail going east-west.");
    public static BoardPiece FRST_4_4 = new BoardPiece(0, 1, 0, 0, 4, 4,
            false, "Deep foreboding forest.");
    public static BoardPiece TRAL_5_2 = new BoardPiece(0, 0, 0, 0, 5, 2,
            false, "A trail going east-west.\nA cabin lies to your east.");
    public static BoardPiece WELL_5_6 = new BoardPiece(0, 0, 5, 0, 5, 6,
            false, "A deep well in a small clearing.");
    public static BoardPiece CABN_6_2 = new BoardPiece(2, 0, 0, 0, 6, 2,
            false, "Dark dank cabin.");
    public static BoardPiece STN_FRST = new BoardPiece(1, 0, 0, 0, 0, 0,
            false, "Deep foreboding forest.");
    public static final BoardPiece MOUNTAIN = new BoardPiece(0, 0, 0, 0, 0, 0, true,
            "Impassable mountains.");

    public static final BoardPiece TEST_1_1 = new BoardPiece(10, 10, 10, 10, 1, 1, false,
            "This area is used for testing");
    public static final BoardPiece TST_STRT = new BoardPiece(0, 0, 0, 0, 1, 2, false,
            "This is the start area for testing");


}
