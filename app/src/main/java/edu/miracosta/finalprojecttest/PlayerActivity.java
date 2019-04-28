package edu.miracosta.finalprojecttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

    }

    //TODO: Connect the PlayActivity to this activity so they can share intent(player object).
    //TODO: Look at ActionActivity as an example.
    //TODO: The plan is to transfer the player object from its original home in PlayActivity
    //TODO: to the target, PlayerActivity, and depending on the button the user
    //TODO: presses in PlayerActivity, the player object will be sent to another Activity.

}
