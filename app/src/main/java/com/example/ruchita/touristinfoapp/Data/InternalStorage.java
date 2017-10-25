package com.example.ruchita.touristinfoapp.Data;

import android.content.Context;
import android.util.Log;

import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Ruchita on 21-10-2017.
 */
// A class to store data.
public class InternalStorage implements DataProvider {
    private static final String TAG = InternalStorage.class.getSimpleName();
    //@Constant CITY_FILE is a string type to hold a string value.
    private static String CITY_FILE = "cities.json";
    // Field variables of class InternalStorage.
    private Context mContext;
    private static InternalStorage mInstance;
    private ArrayList<City> mCities;

    // constructor of class InternalStorage.
    private InternalStorage(Context context) {
        mContext = context;
        mCities = getCitiesFromFile();
    }

    // A method to get the instance of InternalStorage.
    public static InternalStorage getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new InternalStorage(context.getApplicationContext());
        }
        return mInstance;
    }

    // A method to update the hardcoded data.
    public void updateDataWithHardCodedData() {
        if (CommonUtils.getLaunchCount(mContext) == 0) {
            DataProvider hardCodedData = new TestData();
            mCities.addAll(hardCodedData.getCities());
            saveCitiesToFile();
        }
    }

    @Override
    public ArrayList<City> getCities() {
        return mCities;
    }

    @Override
    public String updateCity(City city) {
        return null;
    }

    @Override
    public void addCity(City city) {
        mCities.add(mCities.size() - 1, city);
        saveCitiesToFile();
    }

    @Override
    public void deleteCity(City city) {
        mCities.remove(city);
        saveCitiesToFile();
    }

    // A method to save the cities in file.
    private void saveCitiesToFile() {
        Gson gson = new Gson();
        String string = gson.toJson(mCities);
        FileOutputStream fos = null;
        try {
            fos = mContext.openFileOutput(CITY_FILE, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        } catch (IOException e) {
            Log.e(TAG, "saveCitiesToFile", e);
        }
    }

    // A method to get the cities from file.
    private ArrayList<City> getCitiesFromFile() {
        try {
            FileInputStream inputStream = mContext.openFileInput(CITY_FILE);
            String json = convertStreamToString(inputStream);
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<City>>() {
            }.getType();
            ArrayList<City> cities = gson.fromJson(json, type);
            return cities;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //A method for converting inputStream into string value.
    private static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
