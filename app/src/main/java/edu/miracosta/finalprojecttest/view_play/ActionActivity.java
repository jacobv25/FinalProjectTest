package edu.miracosta.finalprojecttest.view_play;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
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

    private MediaPlayer woodChopMediaPlayer;
    private MediaPlayer waterCollectMediaPlayer;
    private MediaPlayer waterDrinkFemaleMediaPlayer;
    private MediaPlayer harvestAnimalMediaPlayer;
    private MediaPlayer pickPlantMediaPlayer;
    private MediaPlayer eatFoodMediaPlayer;

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

        woodChopMediaPlayer = MediaPlayer.create(this, R.raw.wood_chop);
        waterCollectMediaPlayer = MediaPlayer.create(this, R.raw.water_collect);
        waterDrinkFemaleMediaPlayer = MediaPlayer.create(this, R.raw.water_drink_female);
        harvestAnimalMediaPlayer= MediaPlayer.create(this, R.raw.harvest_animal);
        pickPlantMediaPlayer = MediaPlayer.create(this, R.raw.pick_plant);
        eatFoodMediaPlayer = MediaPlayer.create(this, R.raw.eat_food);

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

                Action.harvestAnimal(player, RUNNING_GAME_BOARD, harvestAnimalMediaPlayer);
                break;
            case R.id.pickPlantButton:

                Action.pickPlant(player,RUNNING_GAME_BOARD, pickPlantMediaPlayer);
                break;
            case R.id.getFirewoodButton:

                Action.getFireWood(player, RUNNING_GAME_BOARD, woodChopMediaPlayer);
                break;
            case R.id.collectWaterButton:

                Action.collectWater(player, RUNNING_GAME_BOARD, waterCollectMediaPlayer);
                break;
            case R.id.eatFoodButton:

                Action.eatFood(player, eatFoodMediaPlayer);
                break;
            case R.id.startFireButton:

                Action.startFire(player, time, RUNNING_GAME_BOARD);
                break;
            case R.id.drinkWaterButton:

                Action.drinkWater(player, waterDrinkFemaleMediaPlayer);
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
