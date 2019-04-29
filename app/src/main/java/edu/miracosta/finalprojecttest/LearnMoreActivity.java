package edu.miracosta.finalprojecttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import edu.miracosta.finalprojecttest.model.Plant;

public class LearnMoreActivity extends AppCompatActivity {

    //TODO: Each button (Animals, Plants, Survival Tips) take the user to its specific List View.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);
    }
}
