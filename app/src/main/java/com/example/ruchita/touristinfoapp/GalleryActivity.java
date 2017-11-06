package com.example.ruchita.touristinfoapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ruchita.touristinfoapp.Adapter.ViewPagerAdapter;
import com.example.ruchita.touristinfoapp.Data.CommonUtils;
import com.example.ruchita.touristinfoapp.Data.ImageUtils;
import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

import java.util.List;

public class GalleryActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    /*
     *Field variables of class GalleryActivity.
      */
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra(Constants.FAMOUSPLACES_DATA);
        City city = gson.fromJson(data, City.class);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.showOverflowMenu();
        getSupportActionBar().setTitle(city.getCityName());
        mToolbar.setOnMenuItemClickListener(this);
        List<Bitmap> imageList = ImageUtils.getGalleryImages(this.getApplicationContext(), city);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter(this, imageList);
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        CommonUtils.logout(this);
        return false;
    }
}
