package edu.miracosta.finalprojecttest.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONLoader {

    /**
     * Loads JSON data from a file in the assets directory.
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static List<Animal> loadJSONFromAsset(Context context) throws IOException {
        List<Animal> allAnimals = new ArrayList<>();
        String json;

        InputStream is = context.getAssets().open("Animals.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allAnimalsJSON = jsonRootObject.getJSONArray("Animals");
            int numberOfEvents = allAnimalsJSON.length();

            for (int i = 0; i < numberOfEvents; i++) {
                JSONObject animalJSON = allAnimalsJSON.getJSONObject(i);

                Animal animal = new Animal();

                //Extract the Artist from the JSON object
                animal.setAnimalName(animalJSON.getString("Name"));
                animal.setAnimalDescription(animalJSON.getString("Description"));
                animal.setAnimalImage(animalJSON.getString("ImageName"));
                allAnimals.add(animal);
            }
        }
        catch (JSONException e)
        {
            Log.e("Final project cs134", e.getMessage());
        }

        return allAnimals;
    }
}
