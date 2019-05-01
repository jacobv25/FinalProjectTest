package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.miracosta.finalprojecttest.model.Action;
import edu.miracosta.finalprojecttest.model.GameTime;
import edu.miracosta.finalprojecttest.model.Player;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

public class ActionActivity extends AppCompatActivity {

    private static final String TAG = PlayActivity.class.getSimpleName();

    private Button harvestAnimalButton;
    private Button pickPlantButton;
    private Button getFireWoodButton;
    private Button collectWaterButton;

    private Button eatFoodButton;
    private Button startFireButton;
    private Button drinkWaterButton;

    private String displayText;
    private Player player;
    private GameTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        harvestAnimalButton = findViewById(R.id.harvestAnimalButton);
        pickPlantButton = findViewById(R.id.pickPlantButton);
        getFireWoodButton = findViewById(R.id.getFirewoodButton);
        collectWaterButton = findViewById(R.id.collectWaterButton);
        eatFoodButton = findViewById(R.id.eatFoodButton);
        startFireButton = findViewById(R.id.startFireButton);
        drinkWaterButton = findViewById(R.id.drinkWaterButton);

        Intent intent = getIntent();

        player = intent.getParcelableExtra("Player");
        //Inventory inventory = (intent.getParcelableExtra("Inventory"));
        //player.setInventory(inventory);
        displayText = intent.getStringExtra("DisplayText");
        time = intent.getParcelableExtra("GameTime");
    }

    public void harvestFoodButtonPressed(View v) {

        Intent intent = new Intent();

        Action.harvestAnimal(player, RUNNING_GAME_BOARD);

        intent.putExtra("Player", player);
        //intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", player.getDisplayText());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void pickPlantButtonPressed(View v) {

        Intent intent = new Intent();

        Action.pickPlant(player, RUNNING_GAME_BOARD);

        intent.putExtra("Player", player);
        //intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", player.getDisplayText());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void lookButtonPressed(View v) {

        Intent intent = new Intent();

        Action.look(player, RUNNING_GAME_BOARD);

        intent.putExtra("Player", player);
        intent.putExtra("DisplayText", player.getDisplayText());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void getFirewoodButtonPressed(View v) {

        Intent intent = new Intent();

        Action.getFireWood(player, RUNNING_GAME_BOARD);

        intent.putExtra("Player", player);
        //intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", player.getDisplayText());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void startFireButtonPressed(View v) {

        Intent intent = new Intent();

        Action.startFire(player, time, RUNNING_GAME_BOARD);

        intent.putExtra("Player", player);
        intent.putExtra("DisplayText", player.getDisplayText());
        setResult(RESULT_OK, intent);
        finish();
    }
    //TODO: Finish linking the buttons to the back end
}
