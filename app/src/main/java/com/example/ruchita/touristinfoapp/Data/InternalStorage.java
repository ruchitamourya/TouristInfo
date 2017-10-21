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
 * Created by Chandan on 21-10-2017.
 */

public class InternalStorage implements DataProvider {
    private static final String TAG = InternalStorage.class.getSimpleName();
    private static String CITY_FILE = "cities.json";
    private Context mContext;
    private static InternalStorage instance;
    private ArrayList<City> mCities;

    private InternalStorage(Context context) {
        mContext = context;
        mCities = getCitiesFromFile();
    }

    public static InternalStorage getInstance(Context context){
        if(instance == null){
            instance = new InternalStorage(context.getApplicationContext());
        }
        return instance;
    }

    public void updateDataWithHardCodedData() {
        if(CommonUtils.getLaunchCount(mContext) == 0){
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
        mCities.add(mCities.size()-1, city);
        saveCitiesToFile();
    }

    @Override
    public void deleteCity(City city) {
        mCities.remove(city);
        saveCitiesToFile();
    }

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

    private ArrayList<City> getCitiesFromFile() {
        try {
            FileInputStream inputStream = mContext.openFileInput(CITY_FILE);
            String json = convertStreamToString(inputStream);
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<City>>(){}.getType();
            ArrayList<City> cities = gson.fromJson(json, type);
            return cities;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

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
