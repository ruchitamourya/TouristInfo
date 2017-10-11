package com.example.ruchita.touristinfoapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;

public class CityListActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        fragmentManager = getSupportFragmentManager();
        addCityNameFragment();


    }

    public void addCityNameFragment() {

        CityNameRecyclerViewFragment cityNameRecyclerViewFragment = new CityNameRecyclerViewFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, cityNameRecyclerViewFragment, Constants.FRAGMENT);
        transaction.commit();

    }
}


