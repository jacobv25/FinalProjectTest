package edu.miracosta.finalprojecttest.view_play;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.miracosta.finalprojecttest.MainActivity;
import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.player.Player;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_FINISH;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView deathTextView = findViewById(R.id.deathTextView);

        final Intent intent = getIntent();
        final Intent intentMain = new Intent(this, MainActivity.class);
        final Handler handler = new Handler();

        Player player = intent.getParcelableExtra("Player");

        if (player.getY()==RUNNING_GAME_FINISH.getY() && player.getX()==RUNNING_GAME_FINISH.getX()) {
            deathTextView.setTextColor(getResources().getColor(R.color.colorBlue));
            deathTextView.setText("You made it safely to the town.");

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 3s = 3000ms
                    startActivity(intentMain);
                }
            }, 3000);
        }
        else if (player.getCondition() == 0) {
            deathTextView.setTextColor(getResources().getColor(R.color.colorRed));
            deathTextView.setText("You are dead.");

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 3s = 3000ms
                    startActivity(intentMain);
                }
            }, 3000);
        }
    }
}
