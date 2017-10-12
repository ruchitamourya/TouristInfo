package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

public class CityDetailPageActivity extends AppCompatActivity implements View.OnClickListener,Toolbar.OnMenuItemClickListener {

    private ImageView city_image;
    private TextView city_details;
    private Button famous_places;
    private Button gallery;
    private Toolbar toolbar;

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail_page);

        city_image = (ImageView) findViewById(R.id.city_image);
        city_details = (TextView) findViewById(R.id.details);
        famous_places = (Button) findViewById(R.id.famous_places);
        gallery = (Button) findViewById(R.id.gallery);

        famous_places.setOnClickListener(this);
        gallery.setOnClickListener(this);

        populateData();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();
        getSupportActionBar().setTitle("Tourist Info App ");
        toolbar.setOnMenuItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void populateData() {
        Gson gson = new Gson();
         data = getIntent().getStringExtra(Constants.CITY_DATA);
        City city = gson.fromJson(data, City.class);
        city_image.setImageResource(city.getCityDetail().getImageId());
        city_details.setText(city.getCityDetail().getDescription());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.famous_places) {
            Intent intent = new Intent(CityDetailPageActivity.this, FamousPlacesActivity.class);
            intent.putExtra(Constants.FAMOUSPLACES_DATA,data);
            startActivity(intent);
        } else if (v.getId() == R.id.gallery) {
            Intent intent = new Intent(CityDetailPageActivity.this, GalleryActivity.class);
            intent.putExtra(Constants.FAMOUSPLACES_DATA,data);
            startActivity(intent);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        onLogout();
        return false;
    }

    public void onLogout(){
        Intent intent = new Intent(this,SplashActivity.class);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants.IS_LOGGED_IN, false);
        editor.apply();
        startActivity(intent);
    }
}
