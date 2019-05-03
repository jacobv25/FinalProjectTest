package edu.miracosta.finalprojecttest.model.board_game;

import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.CABN_6_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.FREE;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.MOUNTAIN;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.OBST;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_3;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_4;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_5;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.ROAD_2_6;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TEST_X_Y;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TRAL_3_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TRAL_4_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TRAL_5_2;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TST_STRT;

/**
 * Handles the different 2d arrays that act as game boards
 */
public class BoardGame {


    /**
     * v.0.1 design
     */
    public static final int[][] GAME_BOARD = {
            {OBST, OBST, OBST, OBST, OBST, OBST, OBST, OBST},
            {OBST, OBST, OBST, FREE, FREE, FREE, FREE, FREE},
            {FREE, FREE, FREE, OBST, OBST, FREE, OBST, FREE},
            {FREE, OBST, OBST, FREE, OBST, FREE, OBST, FREE},
            {FREE, FREE, FREE, FREE, OBST, FREE, OBST, FREE},
            {OBST, OBST, OBST, FREE, OBST, FREE, OBST, FREE},
            {OBST, FREE, FREE, FREE, FREE, FREE, OBST, FREE},
            {OBST, OBST, OBST, OBST, OBST, OBST, OBST, OBST}
    };
    /**
     * v.0.2 design
     *
     * Used as a tester
     */
    public static final BoardPiece[][] GAME_BOARD_PIECES = {
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, ROAD_2_2, TRAL_3_2, TRAL_4_2, TRAL_5_2, CABN_6_2, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, ROAD_2_3, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, ROAD_2_4, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, ROAD_2_5, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, ROAD_2_6, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
    };
    /**
     * v.0.3 design
     *
     * Used as a tester
     */
    public static final BoardPiece[][] GAME_BOARD_PIECES_TEST = {
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, TEST_X_Y, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, TST_STRT, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
    };

    /**
     * The custom areas/pieces.
     */
    public static final BoardPiece[] ACTIVE_PIECES = {CABN_6_2, TRAL_5_2,
                                                        TRAL_4_2, TRAL_3_2};

    public static void update() {

        for(int i=0; i<ACTIVE_PIECES.length; i++) {

            ACTIVE_PIECES[i].update();
        }
    }


}
