package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //Delay activity with TimerTask
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent musicIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(musicIntent);
                //Finish the current activity (finish SplashActivity)
                finish();
            }
        };


        Timer timer = new Timer();
        timer.schedule(task, 3000);

        //Any loading code goes her(DBHelper gets instantiated, loading JSON)


    }
}
