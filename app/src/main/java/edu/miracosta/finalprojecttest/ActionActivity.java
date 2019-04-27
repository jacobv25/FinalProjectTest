package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import edu.miracosta.finalprojecttest.model.Inventory;
import edu.miracosta.finalprojecttest.model.Player;

public class ActionActivity extends AppCompatActivity {

    private static final String TAG = PlayActivity.class.getSimpleName();

    private Button harvestFoodButton;
    private Button pickPlantButton;
    private Button getFireWoodButton;
    private Button collectWaterButton;

    private Button eatFoodButton;
    private Button startFireButton;
    private Button drinkWaterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        harvestFoodButton = findViewById(R.id.harvestFoodButton);
        pickPlantButton = findViewById(R.id.pickPlantButton);
        getFireWoodButton = findViewById(R.id.getFirewoodButton);
        collectWaterButton = findViewById(R.id.collectWaterButton);
        eatFoodButton = findViewById(R.id.eatFoodButton);
        startFireButton = findViewById(R.id.startFireButton);
        collectWaterButton = findViewById(R.id.collectWaterButton);

        Intent playerIntent = getIntent();

        Player player = playerIntent.getParcelableExtra("Player");
        Inventory inventory = (playerIntent.getParcelableExtra("Inventory"));
        player.setInventory(inventory);
    }
}
