package edu.miracosta.finalprojecttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import edu.miracosta.finalprojecttest.model.Plant;

public class LearnMoreListActivity extends AppCompatActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    //private DBHelper db;
    private List<Plant> plantList;
    private LearnMoreListAdapter learnMoreListAdapter;
    private ListView learnMoreListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more_list);

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_learn_more);

            //Adapter code not fully implemented
        /*
        db = new DBHelper(this);

        gamesList = db.getAllGames();
        learnMoreListAdapter = new LearnMoreListAdapter(this, R.layout.learn_more_list_item, plantList);

        learnMoreListView = findViewById(R.id.learnMoreListView);
        learnMoreListView.setAdapter(learnMoreListAdapter);
        */

    }
}
