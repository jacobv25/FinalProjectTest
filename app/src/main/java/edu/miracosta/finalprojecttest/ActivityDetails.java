package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import edu.miracosta.finalprojecttest.model.Plant;

public class ActivityDetails extends AppCompatActivity {

    private TextView detailsNameTextView;
    private TextView detailsDescriptionTextView;
    private ImageView detailsImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent detailsIntent = getIntent();


        Plant plant = detailsIntent.getParcelableExtra("SelectedPlant");


        detailsNameTextView = findViewById(R.id.detailsNameTextView);
        detailsImageView = findViewById(R.id.detailsImageView);
        detailsDescriptionTextView = findViewById(R.id.detailsDescriptionTextView);
        AssetManager am = getAssets();
        try {
            InputStream stream = am.open(plant.getPlantImage());
            Drawable image = Drawable.createFromStream(stream, plant.getPlantName());
            detailsImageView.setImageDrawable(image);
        }
        catch (IOException ex)
        {
            Log.e("ActivityDetails", "Error loading: " + plant.getPlantImage(), ex);
        }

        detailsNameTextView.setText(plant.getPlantName());
        detailsDescriptionTextView.setText(plant.getPlantDetails());
    }


}
