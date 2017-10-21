package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ruchita.touristinfoapp.Adapter.FamousPlacesAdapter;
import com.example.ruchita.touristinfoapp.Data.CommonUtils;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.google.gson.Gson;

public class FamousPlacesActivity extends AppCompatActivity implements ItemClickListenerOfFamousPlace, Toolbar.OnMenuItemClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_places);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();
        toolbar.setOnMenuItemClickListener(this);

        Gson gson = new Gson();
        String data = getIntent().getStringExtra(Constants.FAMOUSPLACES_DATA);
        City city = gson.fromJson(data, City.class);
        getSupportActionBar().setTitle(city.getCityName());
        if (city.getFamousPlaceList() != null && city.getFamousPlaceList().size() > 0) {
            setUpRecyclerView(city);
        }else {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_no_data);
            frameLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void setUpRecyclerView(City city) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setVisibility(View.VISIBLE);
        FamousPlacesAdapter adapter = new FamousPlacesAdapter(this, this, city.getFamousPlaceList(), city.getCityName());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        CommonUtils.logout(this);
        return false;
    }

    @Override
    public void onItemClick(View view, FamousPlace famousPlace) {
        Intent intent = new Intent(this, MapsActivity.class);
        double lat = famousPlace.getLatitude();
        double log = famousPlace.getLongitude();
        intent.putExtra("lat", lat);
        intent.putExtra("log", log);
        startActivity(intent);
    }
}

