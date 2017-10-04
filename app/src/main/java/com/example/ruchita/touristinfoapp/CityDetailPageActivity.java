package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

public class CityDetailPageActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView city_image;
    private TextView city_details;
    private Button famous_places;
    private Button gallery;

    public static final String CITY_KEY = "city_key";
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
    }

    public void populateData() {
        Gson gson = new Gson();
         data = getIntent().getStringExtra("key");
        City city = gson.fromJson(data, City.class);
        city_image.setImageResource(city.getCityDetail().getImageId());
        city_details.setText(city.getCityDetail().getDescription());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.famous_places) {
            Intent intent = new Intent(CityDetailPageActivity.this, FamousPlacesActivity.class);
            intent.putExtra(CITY_KEY,data);
            startActivity(intent);
        } else if (v.getId() == R.id.gallery) {
            Intent intent = new Intent(CityDetailPageActivity.this, GalleryActivity.class);
            intent.putExtra(CITY_KEY,data);
            startActivity(intent);
        }
    }
}
