package com.example.ruchita.touristinfoapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ruchita.touristinfoapp.Adapter.ViewPagerAdapter;
import com.example.ruchita.touristinfoapp.Data.CommonUtils;
import com.example.ruchita.touristinfoapp.Data.ImageUtils;
import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

import java.util.List;

public class GalleryActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    //Field variables of class GalleryActivity.
    private ViewPager mViewPager;
    private ProgressBar mProgressBar;
    private ViewPagerAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra(Constants.FAMOUS_PLACES_DATA);
        City city = gson.fromJson(data, City.class);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.showOverflowMenu();
        getSupportActionBar().setTitle(city.getCityName());
        mToolbar.setOnMenuItemClickListener(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mProgressBar.setVisibility(View.VISIBLE);
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute(city);
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

    private class MyAsyncTask extends AsyncTask<City, Integer, List<Bitmap>> {
        @Override
        protected List<Bitmap> doInBackground(City... params) {
            List<Bitmap> imageList = ImageUtils.getGalleryImages(GalleryActivity.this, params[0]);
            return imageList;
        }

        @Override
        protected void onPostExecute(List<Bitmap> bitmaps) {
            mAdapter = new ViewPagerAdapter(GalleryActivity.this, bitmaps);
            mViewPager.setAdapter(mAdapter);
            mProgressBar.setVisibility(View.GONE);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
