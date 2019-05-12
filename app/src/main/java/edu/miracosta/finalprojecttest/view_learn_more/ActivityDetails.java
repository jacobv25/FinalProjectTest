package edu.miracosta.finalprojecttest.view_learn_more;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.R;

public class ActivityDetails extends AppCompatActivity {

    private TextView detailsNameTextView;
    private TextView detailsDescriptionTextView;
    private ImageView detailsImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent detailsIntent = getIntent();


        String name = detailsIntent.getStringExtra("Name");
        String description = detailsIntent.getStringExtra("Description");
        String imageName = detailsIntent.getStringExtra("ImageName");



        detailsNameTextView = findViewById(R.id.detailsNameTextView);
        detailsImageView = findViewById(R.id.detailsImageView);
        detailsDescriptionTextView = findViewById(R.id.detailsDescriptionTextView);
        AssetManager am = getAssets();
        try {
            InputStream stream = am.open(imageName);
            Drawable image = Drawable.createFromStream(stream, name);
            detailsImageView.setImageDrawable(image);
        }
        catch (IOException ex)
        {
            Log.e("ActivityDetails", "Error loading: " + imageName);
        }

        detailsNameTextView.setText(name);
        detailsDescriptionTextView.setText(description);
    }


}
