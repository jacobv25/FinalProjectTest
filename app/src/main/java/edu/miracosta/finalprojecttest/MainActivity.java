package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button learnMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playGameButton);
        learnMoreButton = findViewById(R.id.learnMoreButton);
    }

    public void startGame(View V) {

        Intent startGameIntent = new Intent(this, PlayActivity.class);

        startActivity(startGameIntent);

    }

    public void switchToLearnMoreActivity(View V) {

        Intent learnMoreIntent = new Intent(this, LearnMoreActivity.class);

        startActivity(learnMoreIntent);
    }
}
