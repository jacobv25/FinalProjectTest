package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.miracosta.finalprojecttest.model.BoardGame;
import edu.miracosta.finalprojecttest.model.Damage;
import edu.miracosta.finalprojecttest.model.GameTime;
import edu.miracosta.finalprojecttest.model.Inventory;
import edu.miracosta.finalprojecttest.model.Player;
import edu.miracosta.finalprojecttest.model.Regeneration;
import edu.miracosta.finalprojecttest.model.StoryElements;
import edu.miracosta.finalprojecttest.model.Weather;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

public class PlayActivity extends AppCompatActivity {

    private final static int REQUEST_CODE_1 = 1;

    //public static String DISPLAY_TEXT;

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private Button actionButton;
    private Button inventoryButton;
    private TextView currentAreaTextView;
    private TextView playerConditionTextView;
    private TextView bigTextView;
    
    private Player player;
    private GameTime gameTime;
    private Weather weather;

    //TODO: Get rid of member variable displayText.
    //TODO: We wont need it since Player class will provide the diplay text
    //TODO: for currentAreaTextView.
    //private String displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        northButton = findViewById(R.id.northButton);
        southButton = findViewById(R.id.southButton);
        eastButton = findViewById(R.id.eastButton);
        westButton = findViewById(R.id.westButton);
        actionButton = findViewById(R.id.actionButton);
        inventoryButton = findViewById(R.id.playerButton);
        currentAreaTextView = findViewById(R.id.currentAreaTextView);
        playerConditionTextView = findViewById(R.id.playerConditionTextView);

        player = new Player();
        gameTime = new GameTime();
        weather = new Weather();

        playerConditionTextView.setText("HP= " + player.getCondition() +
                " | Temp= " + player.getTemperature() +
                " | Hunger= " + player.getHunger() +
                " | Thirst= " + player.getThirst());

        //currentAreaTextView.setText(RUNNING_GAME_BOARD[player.getY()][player.getX()].getDisplayText());
        currentAreaTextView.setText(StoryElements.INTRO);

    }

    public void movePlayer(View v) {

        String buttonText = ((Button)v).getText().toString();
        System.out.println(buttonText);

        if (buttonText.equals("E") || buttonText.equals("W") ||
                buttonText.equals("N") || buttonText.equals("S")) {
            //move player
            player.movePlayerBoardPiece(buttonText, player, RUNNING_GAME_BOARD);
            currentAreaTextView.setText(player.getDisplayText());
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

        isPlayerDead(player);
    }

    public void actionButtonPressed(View v) {

        Intent intent = new Intent(this, ActionActivity.class);

        intent.putExtra("Player", player);
        intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", player.getDisplayText());

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
                    Inventory inventory = data.getParcelableExtra("Inventory");
                    player.setInventory(inventory);
                    //Decide which text view to use
                    //if (player.getDisplayText().length() > 200) {

                      //  bigTextView.setText(player.getDisplayText());
                    //}
                    //else {

                        currentAreaTextView.setText(player.getDisplayText());
                    //}

                    //update the player condition text view
                    playerConditionTextView.setText("HP= " + player.getCondition() +
                            " | Temp= " + player.getTemperature() +
                            " | Hunger= " + player.getHunger() +
                            " | Thirst= " + player.getThirst());

                    Damage.damagePlayer(player, weather, gameTime);
                    Regeneration.regeneratePlayer(player);
                    gameTime.passTime();
                    BoardGame.update();
                }
        }
    }

    private void isPlayerDead(Player player) {

        if (player.getCondition() == 0) {

            Intent intent = new Intent(this, DeathScreenActivity.class);

            startActivity(intent);
        }
    }
}
