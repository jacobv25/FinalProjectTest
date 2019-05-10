package edu.miracosta.finalprojecttest.view_play;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.StoryElements;
import edu.miracosta.finalprojecttest.model.board_game.BoardGame;
import edu.miracosta.finalprojecttest.model.player.Action;
import edu.miracosta.finalprojecttest.model.player.Damage;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.player.Player;
import edu.miracosta.finalprojecttest.model.player.Regeneration;
import edu.miracosta.finalprojecttest.model.enviroment.Weather;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_FINISH;

public class PlayActivity extends AppCompatActivity {

    private final static int REQUEST_CODE_1 = 1;

    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String PASS_TIME = "WAIT";

    //public static String DISPLAY_TEXT;

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private Button actionButton;
    private Button inventoryButton;
    private TextView currentAreaTextView;
    private TextView playerConditionTextView;
    private TextView timeTextView;
    
    private Player player;
    private GameTime gameTime;
    private Weather weather;

    private MediaPlayer cabinAmbientMediaPlayer;
    private MediaPlayer forestDayAmbientMediaPlayer;
    private MediaPlayer forestNightAmbientMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        northButton = findViewById(R.id.northButton);
        southButton = findViewById(R.id.southButton);
        eastButton = findViewById(R.id.eastButton);
        westButton = findViewById(R.id.westButton);
        actionButton = findViewById(R.id.actionButton);
        inventoryButton = findViewById(R.id.inventoryButton);
        currentAreaTextView = findViewById(R.id.currentAreaTextView);
        playerConditionTextView = findViewById(R.id.playerConditionTextView);
        timeTextView = findViewById(R.id.timeTextView);

        cabinAmbientMediaPlayer = MediaPlayer.create(this, R.raw.cabin_fire);
        forestDayAmbientMediaPlayer = MediaPlayer.create(this, R.raw.forest_ambient_day);
        forestNightAmbientMediaPlayer = MediaPlayer.create(this, R.raw.forest_ambient_night);

        player = new Player();
        gameTime = new GameTime();
        weather = new Weather();
        playerConditionTextView.setText("HP= " + player.getCondition() +
                " | Temp= " + player.getTemperature() +
                " | Hunger= " + player.getHunger() +
                " | Thirst= " + player.getThirst());
        timeTextView.setText(gameTime.getDayTimeFormatted());
        currentAreaTextView.setText(StoryElements.HOW_TO_PLAY);
        forestDayAmbientMediaPlayer.start();
    }

    public void movePlayer(View v) {
        String buttonText = ((Button)v).getText().toString();

        if (buttonText.equals(EAST) || buttonText.equals(PASS_TIME) ||
                buttonText.equals(NORTH) || buttonText.equals(SOUTH) || buttonText.equals(WEST)) {
            //move player
            player.movePlayerBoardPiece(buttonText, player, RUNNING_GAME_BOARD);
            currentAreaTextView.setText(player.getDisplayText());
        }

        //Check if fire is burning in current area
        if( Action.isFireBurning(player, RUNNING_GAME_BOARD) ) {
            Regeneration.regenFromFire(player);
        }

        Damage.damagePlayer(player, weather, gameTime);
        Regeneration.regeneratePlayer(player);
        gameTime.passTime();
        BoardGame.update();

        //update the player condition text view
        playerConditionTextView.setText("HP= " + player.getCondition() +
                " | Temp= " + player.getTemperature() +
                " | Hunger= " + player.getHunger() +
                " | Thirst= " + player.getThirst());
        //check if player is dead
        isPlayerDead(player);
        //check if player made it to finish
        didPlayerWin(player);
        //update the day time
        timeTextView.setText(gameTime.getDayTimeFormatted());
        //update the music
        System.out.println("Is player inside=" + player.isPlayerInside(RUNNING_GAME_BOARD));
        playMedia();
    }

    public void inventoryButtonPressed(View v) {
        Intent intent = new Intent(this, InventoryListActivity.class);

        intent.putExtra("Player", player);

        startActivity(intent);
    }

    public void actionButtonPressed(View v) {

        Intent intent = new Intent(this, ActionActivity.class);

        intent.putExtra("Player", player);
        //intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", player.getDisplayText());
        intent.putExtra("GameTime", gameTime);

        startActivityForResult(intent, REQUEST_CODE_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // The returned result data is identified by requestCode.
        // The request code is specified in startActivityForResult(intent, REQUEST_CODE_1); method.
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:
                if(resultCode == RESULT_OK)
                {
                    player = data.getParcelableExtra("Player");
                    //Inventory inventory = data.getParcelableExtra("Inventory");
                    //player.setInventory(inventory);

                    currentAreaTextView.setText(player.getDisplayText());

                    Damage.damagePlayer(player, weather, gameTime);
                    Regeneration.regeneratePlayer(player);
                    gameTime.passTime();
                    BoardGame.update();

                    //Check if fire is burning in current area
                    if( Action.isFireBurning(player, RUNNING_GAME_BOARD) ) {
                        Regeneration.regenFromFire(player);
                    }

                    //update the player condition text view
                    playerConditionTextView.setText("HP= " + player.getCondition() +
                            " | Temp= " + player.getTemperature() +
                            " | Hunger= " + player.getHunger() +
                            " | Thirst= " + player.getThirst());
                    //update the time
                    timeTextView.setText(gameTime.getDayTimeFormatted());
                    //check if player is dead
                    isPlayerDead(player);
                    //check if player reached finish
                    didPlayerWin(player);
                }
        }
    }

    private void playMedia() {

        if (player.isPlayerInside(RUNNING_GAME_BOARD)) {
            forestDayAmbientMediaPlayer.pause();
            forestNightAmbientMediaPlayer.pause();
            cabinAmbientMediaPlayer.start();
        }
        else {
            cabinAmbientMediaPlayer.pause();
            //if the day time is between 7am and 7pm
            if (gameTime.getDayTime() > 420 &&
                    gameTime.getDayTime() < 1140) {
                System.out.println("PLAYING DAY AMBIENT");
                forestNightAmbientMediaPlayer.pause();
                forestDayAmbientMediaPlayer.start();
            }
            else {
                System.out.println("playing night music");
                forestDayAmbientMediaPlayer.pause();
                forestNightAmbientMediaPlayer.start();
            }

        }
    }

    private void isPlayerDead(Player player) {

        if (player.getCondition() == 0) {

            Intent intent = new Intent(this, EndGameActivity.class);
            intent.putExtra("Player", player);
            intent.putExtra("GameTime", gameTime);
            startActivity(intent);
        }
    }

    private void didPlayerWin(Player player) {

        if( player.getX() == RUNNING_GAME_FINISH.getX() && player.getY() == RUNNING_GAME_FINISH.getY()) {

            Intent intent = new Intent(this, EndGameActivity.class);
            intent.putExtra("Player", player);
            intent.putExtra("GameTime", gameTime);
            startActivity(intent);
        }
    }



}
