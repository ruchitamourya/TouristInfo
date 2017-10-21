package com.example.ruchita.touristinfoapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ruchita.touristinfoapp.Data.CommonUtils;

public class CityListActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    private FragmentManager fragmentManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        fragmentManager = getSupportFragmentManager();
        addCityNameFragment();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();
        getSupportActionBar().setTitle("Cities");
        toolbar.setOnMenuItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void addCityNameFragment() {
        CityNameRecyclerViewFragment cityNameRecyclerViewFragment = new CityNameRecyclerViewFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, cityNameRecyclerViewFragment, Constants.FRAGMENT);
        transaction.commit();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        CommonUtils.logout(this);
        return false;
    }
}


