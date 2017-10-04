package com.example.ruchita.touristinfoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ruchita.touristinfoapp.Adapter.FamousPlacesAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

public class FamousPlacesActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_places);

        setUpRecyclerView();

    }
    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra(CityDetailPageActivity.CITY_KEY);
        City city = gson.fromJson(data,City.class);
        FamousPlacesAdapter adapter = new FamousPlacesAdapter(this, city.getFamousPlaceList());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onClick(View v) {

    }
}

