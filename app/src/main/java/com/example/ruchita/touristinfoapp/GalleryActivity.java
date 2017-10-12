package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ruchita.touristinfoapp.Adapter.ViewPagerAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

public class GalleryActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

   private ViewPager viewPager;
   private ViewPagerAdapter adapter;
   private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();
        getSupportActionBar().setTitle("Tourist Info App ");
        toolbar.setOnMenuItemClickListener(this);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra(Constants.FAMOUSPLACES_DATA);
        City city = gson.fromJson(data,City.class);
        adapter = new ViewPagerAdapter(this,city.getFamousPlaceList());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
