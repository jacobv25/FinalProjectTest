package edu.miracosta.finalprojecttest.view_play;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.enviroment.Item;
import edu.miracosta.finalprojecttest.model.player.Player;

public class InventoryListActivity extends ListActivity {

    private List<Item> allItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        Player player = intent.getParcelableExtra("Player");

        allItems = player.getInventory();

        ListView inventoryListView = findViewById(R.id.inventoryListView);

        setListAdapter(new InventoryListAdapter(this, R.layout.inventory_list_item, allItems));
    }

    //TODO: Implement a custom list adapter and use it to build a ListView of the player's inventory.
}
