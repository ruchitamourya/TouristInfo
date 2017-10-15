package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ruchita.touristinfoapp.Adapter.FamousPlacesAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.google.gson.Gson;

public class FamousPlacesActivity extends AppCompatActivity implements ItemClickListenerOfFamousPlace,Toolbar.OnMenuItemClickListener{

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_places);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();
        getSupportActionBar().setTitle("Tourist Info App ");
        toolbar.setOnMenuItemClickListener(this);

        setUpRecyclerView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra(Constants.FAMOUSPLACES_DATA);
        City city = gson.fromJson(data,City.class);
        FamousPlacesAdapter adapter = new FamousPlacesAdapter(this, this,city.getFamousPlaceList());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        onLogout();
        return false;
    }

    public void onLogout() {
        Intent intent = new Intent(this, SplashActivity.class);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants.IS_LOGGED_IN, false);
        editor.apply();
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, FamousPlace famousPlace) {
        Intent intent = new Intent(this,MapsActivity.class);
        double lat = famousPlace.getLatitude();
        double log = famousPlace.getLongitude();
        intent.putExtra("lat",lat);
        intent.putExtra("log",log);
        startActivity(intent);
    }
}

