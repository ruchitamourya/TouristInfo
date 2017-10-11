package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ruchita.touristinfoapp.Adapter.ViewPagerAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

public class GalleryActivity extends AppCompatActivity {

    ViewPager viewPager;
     ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra(Constants.FAMOUSPLACES_DATA);
        City city = gson.fromJson(data,City.class);
        adapter = new ViewPagerAdapter(this,city.getFamousPlaceList());
        viewPager.setAdapter(adapter);
    }
}
