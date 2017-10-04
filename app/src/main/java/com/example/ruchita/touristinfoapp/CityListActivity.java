package com.example.ruchita.touristinfoapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ruchita.touristinfoapp.Adapter.CityGridAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.TestData;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CityListActivity extends AppCompatActivity implements ItemClickListener {

    public static final String TAG = CityListActivity.class.getSimpleName();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        setUpRecyclerView();
        fragmentManager = getFragmentManager();
    }

    private void setUpRecyclerView() {
        getFragmentManager();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        ArrayList<City> data = TestData.prepareCityList();
        CityGridAdapter adapter = new CityGridAdapter(this, this, data);

        recyclerView.setAdapter(adapter);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this,2);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mGridLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(View view, City current) {
        if(view.getId() == R.id.cardView) {
            if (!current.getCityName().equals(Constants.ADD_NEW_CITY)) {
                openDetailsActivity(current);
            } else {
                addNewCityFragment();
            }
        }
    }

    private void openDetailsActivity(City current) {
        String data;
        Intent intent = new Intent(this, CityDetailPageActivity.class);
        Gson gson = new Gson();
        data = gson.toJson(current);
        intent.putExtra("key", data);
        startActivity(intent);
    }

    public void addNewCityFragment() {
        AddNewCityFragment fragment = new AddNewCityFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment, "fragA");
        transaction.addToBackStack("fragA");
        transaction.commit();
    }
}

