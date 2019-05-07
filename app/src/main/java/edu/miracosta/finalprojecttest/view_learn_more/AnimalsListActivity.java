package edu.miracosta.finalprojecttest.view_learn_more;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.enviroment.Animal;
import edu.miracosta.finalprojecttest.model.JSONLoader;

public class AnimalsListActivity extends ListActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    private List<Animal> allAnimals;
    private ListView animalsListView;

    private LearnMoreListAdapter learnMoreListAdapter;
    private ListView learnMoreListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            allAnimals = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("Final Project", "Error loading JSON" + e.getMessage());
        }

        animalsListView = findViewById(R.id.animalsLearnMoreListView);

        setListAdapter(new LearnMoreListAdapter(this, R.layout.learn_more_list_item, allAnimals));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, ActivityDetails.class);
        // ListItems correspond to the List entries by position

        Animal selectedAnimal = allAnimals.get(position);

        detailsIntent.putExtra("Name", selectedAnimal.getAnimalName());
        detailsIntent.putExtra("Description", selectedAnimal.getAnimalDescription());
        detailsIntent.putExtra("ImageName", selectedAnimal.getAnimalImage());

        startActivity(detailsIntent);

    }
}
