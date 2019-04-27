package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.miracosta.finalprojecttest.model.Action;
import edu.miracosta.finalprojecttest.model.GameTime;
import edu.miracosta.finalprojecttest.model.Player;
import edu.miracosta.finalprojecttest.model.Weather;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

public class PlayActivity extends AppCompatActivity {

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private Button actionButton;
    private Button inventoryButton;
    private TextView currentAreaTextView;
    
    private Player player;
    private GameTime gameTime;
    private Weather weather;

    private String displayText;
    
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

        player = new Player();
        gameTime = new GameTime();
        weather = new Weather();

    }

    public void movePlayer(View v) {

        String buttonText = ((Button)v).getText().toString();
        System.out.println(buttonText);

        if (buttonText.equals("E") || buttonText.equals("W") ||
                buttonText.equals("N") || buttonText.equals("S")) {
            //move player
            player.movePlayerBoardPiece(buttonText, player, RUNNING_GAME_BOARD, displayText);
            System.out.println("displayText=" + displayText);
            currentAreaTextView.setText(displayText);
        }
    }

    public void actionButtonPressed(View v) {

        Intent intent = new Intent(this, ActionActivity.class);

        intent.putExtra("Player", player);
        intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", displayText);

        startActivity(intent);
    }
    private void decideAction(String buttonText, Player player, GameTime time, String displayText) {

        switch (buttonText) {

            case "firewood":

                Action.getFireWood(player, displayText, RUNNING_GAME_BOARD);
                currentAreaTextView.append("\n" + displayText);
                break;
            case "start fire":

                Action.startFire(player, gameTime, displayText);
                currentAreaTextView.append("\n" + displayText);
                break;
            case "harvest food":

                Action.harvestAnimal(player, displayText, RUNNING_GAME_BOARD);
                currentAreaTextView.append("\n" + displayText);
                break;
            case "collect water":

                Action.collectWater(player, displayText);
                currentAreaTextView.append("\n" + displayText);
                break;
            case "drink water":

                Action.drinkWater(player, displayText);
                currentAreaTextView.append("\n" + displayText);
                break;
            case "eat food":

                Action.eatFood(player, displayText);
                currentAreaTextView.append("\n" + displayText);
                break;
            default:

                System.out.println("FATAL ERROR IN CONSOLE TESTER");
                System.out.println("EXITING PROGRAM");
                System.exit(0);
        }
    }
}
