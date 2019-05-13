package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.view_learn_more.LearnMoreActivity;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.view_play.PlayActivity;

import static edu.miracosta.finalprojecttest.model.board_game.BoardGame.LEVEL_1;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.CABN_7_2;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.FNSH_1_6;

public class MainActivity extends AppCompatActivity {

    /**
     * HOW TO: Change the RUNNING_GAME_BOARD and RUNNINGG_GAME_START to change the game board
     */
    public static final BoardPiece[][] RUNNING_GAME_BOARD = LEVEL_1;
    public static final BoardPiece RUNNING_GAME_START = CABN_7_2;
    public static final BoardPiece RUNNING_GAME_FINISH = FNSH_1_6;

    private Button playButton;
    private Button learnMoreButton;

    private MediaPlayer riverFluteMediaPlayer;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playGameButton);
        learnMoreButton = findViewById(R.id.learnMoreButton);
        riverFluteMediaPlayer = MediaPlayer.create(this, R.raw.river_flute);
    }

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();

        riverFluteMediaPlayer.start();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (!riverFluteMediaPlayer.isPlaying()) {
            riverFluteMediaPlayer.start();
        }
    }

    /**
     *
     * @param V
     */
    public void switchToPlayActivity(View V) {

        Intent startGameIntent = new Intent(this, PlayActivity.class);
        riverFluteMediaPlayer.stop();
        startActivity(startGameIntent);

    }

    /**
     *
     * @param V
     */
    public void switchToLearnMoreActivity(View V) {

        Intent learnMoreIntent = new Intent(this, LearnMoreActivity.class);

        startActivity(learnMoreIntent);
    }
}
