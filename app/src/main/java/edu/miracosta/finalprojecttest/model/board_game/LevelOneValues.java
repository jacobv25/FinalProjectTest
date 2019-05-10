package edu.miracosta.finalprojecttest.model.board_game;

public class LevelOneValues {

    public static BoardPiece STN_FRST = new BoardPiece(1, 0, 0, 0, 0, 0,
            false, false, "Deep foreboding forest.");
    public static final BoardPiece MOUNTAIN = new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false, "Impassable mountains.");
    public static final BoardPiece _CLIFF__ = new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false,"Go any farther and you'll fall of the cliff.");
    public static BoardPiece __WELL__ = new BoardPiece(0, 0, 3, 0, 0, 0,
            false, false, "A deep well containing water.");
    public static BoardPiece FRT_TREE = new BoardPiece(0, 0, 3, 0, 0, 0,
            false, false, "A clearing with a small tree bearing plump fruit.");
    public static BoardPiece __ROAD__ = new BoardPiece(0, 0, 3, 0, 0, 0,
            false, false, "A road going in the north south direction.");
    public static BoardPiece CLEARING = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "An open clearing in front abin.");
    public static BoardPiece SCRT_PTH = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "A small trail leads away from the road and to a small cave.");
    public static BoardPiece _TRAIL__ = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "A snowy trail with tall white trees on both sides.");
    public static BoardPiece ROAD_3_3 = new BoardPiece(0, 0, 0, 0, 3, 3,
            false, false, "A road going north-south.\nA car crash lays before you");
    public static BoardPiece CABN_7_2 = new BoardPiece(2, 0, 0, 0, 7, 2,
            false, true,"Dark dank cabin.");
    public static BoardPiece FNSH_1_6 = new BoardPiece(0, 0, 0, 0, 1, 6,
            false, true, "A cave that cuts through the mountains to a small town.");

}
