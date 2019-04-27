package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.miracosta.finalprojecttest.model.Action;
import edu.miracosta.finalprojecttest.model.Inventory;
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
        collectWaterButton = findViewById(R.id.collectWaterButton);

        Intent playerIntent = getIntent();

        player = playerIntent.getParcelableExtra("Player");
        Inventory inventory = (playerIntent.getParcelableExtra("Inventory"));
        player.setInventory(inventory);

        displayText = playerIntent.getStringExtra("DisplayText");

    }

    public void harvestFoodButtonPressed(View v) {

        Intent intent = new Intent();

        System.out.println("Before=" + player.displayInventory());
        Action.harvestAnimal(player, displayText, RUNNING_GAME_BOARD);
        System.out.println("After=" + player.displayInventory());

        intent.putExtra("Player", player);
        intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", displayText);
        setResult(RESULT_OK, intent);
        finish();
    }
}
