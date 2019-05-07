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

import edu.miracosta.finalprojecttest.model.enviroment.Animal;
import edu.miracosta.finalprojecttest.model.enviroment.Plant;
import edu.miracosta.finalprojecttest.model.enviroment.Tip;

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
    /**
     * Loads JSON data from a file in the assets directory.
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static List<Plant> loadJSONFromAssetPlant(Context context) throws IOException {
        List<Plant> allPlants = new ArrayList<>();
        String json;

        InputStream is = context.getAssets().open("Plants.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allPlantsJSON = jsonRootObject.getJSONArray("Plants");
            int numberOfEvents = allPlantsJSON.length();

            for (int i = 0; i < numberOfEvents; i++) {
                JSONObject plantJSON = allPlantsJSON.getJSONObject(i);

                Plant plant = new Plant();

                //Extract the Artist from the JSON object
                plant.setPlantName(plantJSON.getString("Name"));
                plant.setPlantDetails(plantJSON.getString("Description"));
                plant.setPlantImage(plantJSON.getString("ImageName"));
                allPlants.add(plant);
            }
        }
        catch (JSONException e)
        {
            Log.e("Final project cs134", e.getMessage());
        }

        return allPlants;
    }
    public static List<Tip> loadJSONFromAssetTips(Context context) throws IOException {
        List<Tip> allTips = new ArrayList<>();
        String json;

        InputStream is = context.getAssets().open("SurvivalTips.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allTipsJSON = jsonRootObject.getJSONArray("SurvivalTips");
            int numberOfEvents = allTipsJSON.length();

            for (int i = 0; i < numberOfEvents; i++) {
                JSONObject tipsJSON = allTipsJSON.getJSONObject(i);

                Tip tip = new Tip();

                //Extract the Artist from the JSON object
                tip.setTipName(tipsJSON.getString("Name"));
                tip.setTipDescription(tipsJSON.getString("Description"));
                tip.setTipImage(tipsJSON.getString("ImageName"));
                allTips.add(tip);
            }
        }
        catch (JSONException e)
        {
            Log.e("Final project cs134", e.getMessage());
        }

        return allTips;
    }
}
