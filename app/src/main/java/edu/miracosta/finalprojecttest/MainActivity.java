package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.miracosta.finalprojecttest.view_learn_more.LearnMoreActivity;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.view_play.PlayActivity;

import static edu.miracosta.finalprojecttest.model.board_game.BoardGame.GAME_BOARD_PIECES;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.CABN_6_2;

public class MainActivity extends AppCompatActivity {

    public static final BoardPiece[][] RUNNING_GAME_BOARD = GAME_BOARD_PIECES;
    public static final BoardPiece RUNNING_GAME_START = CABN_6_2;

    private Button playButton;
    private Button learnMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playGameButton);
        learnMoreButton = findViewById(R.id.learnMoreButton);
    }

    public void startGame(View V) {

        Intent startGameIntent = new Intent(this, PlayActivity.class);

        startActivity(startGameIntent);

    }

    public void switchToLearnMoreActivity(View V) {

        Intent learnMoreIntent = new Intent(this, LearnMoreActivity.class);

        startActivity(learnMoreIntent);
    }
}
