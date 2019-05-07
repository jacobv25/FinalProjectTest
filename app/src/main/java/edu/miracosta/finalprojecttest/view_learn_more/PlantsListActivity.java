package edu.miracosta.finalprojecttest.view_learn_more;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.JSONLoader;
import edu.miracosta.finalprojecttest.model.enviroment.Animal;
import edu.miracosta.finalprojecttest.model.enviroment.Plant;

public class PlantsListActivity extends ListActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    private List<Plant> allPlants;
    private ListView plantsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            allPlants = JSONLoader.loadJSONFromAssetPlant(this);
        } catch (IOException e) {
            Log.e("Final Project", "Error loading JSON" + e.getMessage());
        }

        plantsListView = findViewById(R.id.plantsListView);

        setListAdapter(new PlantsListAdapter(this, R.layout.plant_list_item, allPlants));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, ActivityDetails.class);
        // ListItems correspond to the List entries by position

        Plant selectedPlant = allPlants.get(position);

        detailsIntent.putExtra("Name", selectedPlant.getPlantName());
        detailsIntent.putExtra("Description", selectedPlant.getPlantDetails());
        detailsIntent.putExtra("ImageName", selectedPlant.getPlantImage());

        startActivity(detailsIntent);

    }
}
