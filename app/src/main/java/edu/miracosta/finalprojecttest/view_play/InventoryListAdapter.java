package edu.miracosta.finalprojecttest.view_play;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.enviroment.Item;

public class InventoryListAdapter extends ArrayAdapter<Item> {

    //TODO: Extend ArrayAdapter and decide which constructor to implement.
    //TODO: See pet protector for help.
    //TODO: This may be different than PetProtector because we want to display
    //TODO: an array (inventory[]) within an object(Inventory.java) within another
    //TODO: object (Player). May get tricky.

    private Context mContext;
    private List<Item> mAllItems;
    private int mResourceId;

    public InventoryListAdapter(Context context, int resourceId, List<Item> allItems) {
        super(context, resourceId, allItems);
        mContext = context;
        mResourceId = resourceId;
        mAllItems = allItems;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //Inflate our custom layout with data from the List<MusicEvent>
        Item focusedItem = mAllItems.get(pos);
        //Manually inflate the custom layout
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Tell the inflater to inflate inventory_list_item
        View customView = inflater.inflate(mResourceId, null);
        //Fill the parts of the custom view
        ImageView listItemImageView = customView.findViewById(R.id.inventoryImageView);
        TextView listItemNameTextView = customView.findViewById(R.id.inventoryNameTextView);
        TextView listItemCountTextView = customView.findViewById(R.id.inventoryCountTextView);
        //Put information into text views and image view
        listItemNameTextView.setText(focusedItem.getName());
        listItemCountTextView.setText(Integer.toString(focusedItem.getCount()));
        //Load the image dynamically
        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = ((AssetManager) am).open(focusedItem.getImageName());
            Drawable image = Drawable.createFromStream(stream, focusedItem.getName());
            //Put the image into the image view
            listItemImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("Final Project", e.getMessage());
        }
        return customView;
    }
}
