package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LearnMoreActivity extends AppCompatActivity {

    //TODO: Each button (Animals, Plants, Survival Tips) take the user to its specific List View.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        Button animalsButton = findViewById(R.id.learnMoreAnimalsButton);
        Button plantsButton = findViewById(R.id.learnMorePlantsButton);
        Button survivalTipsButton = findViewById(R.id.learnMoreSurvivalTipsButton);

    }

    public void animalsLearnMoreButtonPressed(View v) {

        Intent intent = new Intent(this, LearnMoreListActivity.class);

        startActivity(intent);
    }
}
