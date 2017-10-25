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
    // Field variables of class CityListActivity.
    private FragmentManager mFragmentManager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        mFragmentManager = getSupportFragmentManager();
        addCityNameFragment();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.showOverflowMenu();
        getSupportActionBar().setTitle("Cities");
        mToolbar.setOnMenuItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // A method to add a fragment on CityListActivity class.
    public void addCityNameFragment() {
        CityNameRecyclerViewFragment cityNameRecyclerViewFragment = new CityNameRecyclerViewFragment();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, cityNameRecyclerViewFragment, Constants.FRAGMENT);
        transaction.commit();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        CommonUtils.logout(this);
        return false;
    }
}


