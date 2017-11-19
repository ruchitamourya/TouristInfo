package com.example.ruchita.touristinfoapp.Data;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Ruchita on 21-10-2017.
 */

//Class to store data.

public abstract class FileDataProvider implements DataProvider {
    private static final String TAG = FileDataProvider.class.getSimpleName();

    // CITY_FILE is a string type constant to hold a string value.
    protected static String CITY_FILE = "cities.json";

    //Field variables of class FileDataProvider.

    protected Context mContext;
    protected static FileDataProvider mInstance;
    private ArrayList<City> mCities;


    //Constructor of class FileDataProvider.
    protected FileDataProvider(Context context) {
        mContext = context;
        mCities = getCitiesFromFile();
    }

    /*
     *Method to update the hardcoded data.
     */
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

    /*
     *Method to save the cities in file.
     */
    private void saveCitiesToFile() {
        Gson gson = new Gson();
        String string = gson.toJson(mCities);
        FileOutputStream fos = null;
        try {
            fos = openFileOutput();
            fos.write(string.getBytes());
        } catch (IOException e) {
            Log.e(TAG, "saveCitiesToFile", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract FileOutputStream openFileOutput() throws FileNotFoundException;

    /*
     *Method to get the cities from file.
      */
    private ArrayList<City> getCitiesFromFile() {
        try {
            FileInputStream inputStream = getFileInputStream();
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

    protected abstract FileInputStream getFileInputStream() throws FileNotFoundException;

    /*
     *Method for converting inputStream into string value.
     */
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
