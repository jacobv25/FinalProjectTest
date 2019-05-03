package edu.miracosta.finalprojecttest;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import edu.miracosta.finalprojecttest.model.Animal;
import edu.miracosta.finalprojecttest.model.JSONLoader;

public class LearnMoreListActivity extends ListActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    //private DBHelper db;
    private List<Animal> allAnimals;
    private ListView animalsListView;

    private LearnMoreListAdapter learnMoreListAdapter;
    private ListView learnMoreListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FINAL PROJECT", "inside on create");
        try {
            allAnimals = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("Final Project", "Error loading JSON" + e.getMessage());
        }

        animalsListView = findViewById(R.id.learnMoreListView);

        setListAdapter(new LearnMoreListAdapter(this, R.layout.learn_more_list_item, allAnimals));
    }
}
