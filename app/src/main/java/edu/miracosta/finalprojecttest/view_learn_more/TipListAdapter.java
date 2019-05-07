package edu.miracosta.finalprojecttest.view_learn_more;

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
import edu.miracosta.finalprojecttest.model.enviroment.Tip;

public class TipListAdapter extends ArrayAdapter<Tip> {

    private Context mContext;
    private List<Tip> mAllTips;
    private int mResourceId;

    /**
     * Creates a new <code>plantListAdapter</code> given a mContext, resource id and list of games.
     *
     * @param context The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param tips The list of plants to display
     */
    public TipListAdapter(Context context, int rId, List<Tip> tips) {
        super(context, rId, tips);
        mContext = context;
        mResourceId = rId;
        mAllTips = tips;
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
        //Inflate our custom layout with data from the List<MusicEvent>
        Tip focusedTip = mAllTips.get(pos);
        //Manually inflate the custom layout
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Tell the inflater to inflate music_event_list_item
        View customView = inflater.inflate(mResourceId, null);
        //Fill the parts of the custom view
        ImageView listItemImageView = customView.findViewById(R.id.tipListItemImageView);
        TextView listItemNameTextView = customView.findViewById(R.id.tipListItemNameTextView);
        TextView listItemDescriptionTextView = customView.findViewById(R.id.tipListItemDescriptionTextView);
        //Put information into text views and image view
        listItemNameTextView.setText(focusedTip.getTipName());
        listItemDescriptionTextView.setText(focusedTip.getTipDescription());
        //Load the image dynamically
        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = ((AssetManager) am).open(focusedTip.getTipImage());
            Drawable image = Drawable.createFromStream(stream, focusedTip.getTipName());
            //Put the image into the image view
            listItemImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("San Diego Music Events", e.getMessage());
        }
        return customView;
    }
}
