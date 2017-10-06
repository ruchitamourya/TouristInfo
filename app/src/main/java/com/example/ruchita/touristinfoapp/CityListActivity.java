package com.example.ruchita.touristinfoapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ruchita.touristinfoapp.Adapter.CityGridAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.TestData;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CityListActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        fragmentManager = getFragmentManager();
        addCityNameFragment();


    }

    public void addCityNameFragment() {

        CityNameRecyclerViewFragment cityNameRecyclerViewFragment = new CityNameRecyclerViewFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, cityNameRecyclerViewFragment, Constants.FRAGMENT);
        transaction.commit();

    }


}


