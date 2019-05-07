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
import edu.miracosta.finalprojecttest.model.JSONLoader;
import edu.miracosta.finalprojecttest.model.enviroment.Tip;

public class TipsListActivity extends ListActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    private List<Tip> allTips;
    private ListView tipsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            allTips = JSONLoader.loadJSONFromAssetTips(this);
        } catch (IOException e) {
            Log.e("Final Project", "Error loading JSON" + e.getMessage());
        }

        tipsListView = findViewById(R.id.tipsLearnMoreListView);

        setListAdapter(new TipListAdapter(this, R.layout.tip_list_item, allTips));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, ActivityDetails.class);
        // ListItems correspond to the List entries by position

        Tip selectedTip = allTips.get(position);

        detailsIntent.putExtra("Name", selectedTip.getTipName());
        detailsIntent.putExtra("Description", selectedTip.getTipDescription());
        detailsIntent.putExtra("ImageName", selectedTip.getTipImage());

        startActivity(detailsIntent);

    }
}
