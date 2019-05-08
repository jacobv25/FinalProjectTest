package edu.miracosta.finalprojecttest.view_play;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.player.Action;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.player.Player;

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


    public void actionButtonPressed(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {

            case R.id.harvestAnimalButton:
                Action.harvestAnimal(player, RUNNING_GAME_BOARD);
                break;
            case R.id.pickPlantButton:
                Action.pickPlant(player,RUNNING_GAME_BOARD);
                break;
            case R.id.getFirewoodButton:
                Action.getFireWood(player, RUNNING_GAME_BOARD);
                break;
            case R.id.collectWaterButton:
                Action.collectWater(player, RUNNING_GAME_BOARD);
                break;
            case R.id.eatFoodButton:
                Action.eatFood(player);
                break;
            case R.id.startFireButton:
                Action.startFire(player, time, RUNNING_GAME_BOARD);
                break;
            case R.id.drinkWaterButton:
                Action.drinkWater(player);
                break;
            case R.id.lookButton:
                Action.look(player, RUNNING_GAME_BOARD);
                break;
        }
        intent.putExtra("Player", player);
        intent.putExtra("DisplayText", player.getDisplayText());
        setResult(RESULT_OK, intent);
        finish();
    }

}
