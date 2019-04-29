package edu.miracosta.finalprojecttest;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import edu.miracosta.finalprojecttest.model.Plant;

/**
 * Helper class to provide custom adapter for the <code>Game</code> list.
 */
public class LearnMoreListAdapter extends ArrayAdapter<Plant> {

    private Context mContext;
    private List<Plant> mPlantsList = new ArrayList<>();
    private int mResourceId;



    /**
     * Creates a new <code>plantListAdapter</code> given a mContext, resource id and list of games.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param plants The list of plants to display
     */
    public LearnMoreListAdapter(Context c, int rId, List<Plant> plants) {
        super(c, rId, plants);
        mContext = c;
        mResourceId = rId;
        mPlantsList = plants;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the Game selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Plant selectedPlant = mPlantsList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout plantListLinearLayout =
                (LinearLayout) view.findViewById(R.id.plantListLinearLayout);
        ImageView plantListImageView =
                (ImageView) view.findViewById(R.id.plantListImageView);
        TextView plantListNameTextView =
                (TextView) view.findViewById(R.id.plantListNameTextView);
        TextView plantListDescriptionTextView =
                (TextView) view.findViewById(R.id.plantListDescriptionTextView);

        plantListLinearLayout.setTag(selectedPlant);
        plantListNameTextView.setText(selectedPlant.getPlantName());
        plantListDescriptionTextView.setText(selectedPlant.getPlantDetails());

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(selectedPlant.getPlantImage());
            Drawable event = Drawable.createFromStream(stream, selectedPlant.getPlantName());
            plantListImageView.setImageDrawable(event);
        }
        catch (IOException ex)
        {
            Log.e("Learn More List Adapter", "Error loading " + selectedPlant.getPlantName(), ex);
        }



        return view;
    }
}
