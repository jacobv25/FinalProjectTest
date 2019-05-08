package edu.miracosta.finalprojecttest.model.board_game;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.CABN_6_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.FNSH_1_6;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.FRST_4_4;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.STN_FRST;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.MOUNTAIN;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_3;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_4;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_5;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_6;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TEST_1_1;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TRAL_3_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TRAL_4_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TRAL_5_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TST_STRT;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.WELL_5_6;

/**
 * Handles the different 2d arrays that act as game boards
 */
public class BoardGame {

    /**
     * Iterate through the double array and update
     * the game board pieces that are NOT mountains
     */
    public static void update() {

        for (int i = 0; i < RUNNING_GAME_BOARD.length; i++) {
            for (int j = 0; j < RUNNING_GAME_BOARD[i].length; j++) {
                if (RUNNING_GAME_BOARD[i][j] != MOUNTAIN) {
                    RUNNING_GAME_BOARD[i][j].update();
                }
            }
        }
    }
    /**
     * v.0.4 design
     *
     * Used as a tester for the final
     */
    public static final BoardPiece[][] GAME_BOARD_PIECES = {
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, STN_FRST, STN_FRST, STN_FRST, STN_FRST, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, STN_FRST, ROAD_2_2, TRAL_3_2, TRAL_4_2, TRAL_5_2, CABN_6_2, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, STN_FRST, ROAD_2_3, MOUNTAIN, STN_FRST, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, STN_FRST, ROAD_2_4, MOUNTAIN, FRST_4_4, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, STN_FRST, ROAD_2_5, MOUNTAIN, STN_FRST, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, FNSH_1_6, ROAD_2_6, MOUNTAIN, STN_FRST, WELL_5_6, STN_FRST, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
    };
    /**
     * v.0.3 design
     *
     * Used as a tester
     */
    public static final BoardPiece[][] GAME_BOARD_PIECES_TEST = {
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, TEST_1_1, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, TST_STRT, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
    };
}
