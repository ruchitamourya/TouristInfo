package com.example.ruchita.touristinfoapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruchita.touristinfoapp.Adapter.CityGridAdapter;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.TestData;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by ruchita on 5/10/17.
 */

public class CityNameRecyclerViewFragment extends Fragment implements ItemClickListener{
    private FragmentManager fragmentManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.city_name_recyclerview_fragment,container,false);
        setUpRecyclerView(view);
        fragmentManager = getFragmentManager();
        return view;

    }

    private void setUpRecyclerView(View v) {

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        ArrayList<City> data = TestData.prepareCityList();
        CityGridAdapter adapter = new CityGridAdapter(getActivity(), this, data);

        recyclerView.setAdapter(adapter);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
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
        Intent intent = new Intent(getActivity(), CityDetailPageActivity.class);
        Gson gson = new Gson();
        data = gson.toJson(current);
        intent.putExtra(Constants.CITY_DATA, data);
        startActivity(intent);
    }

    public void addNewCityFragment() {
        AddNewCityFragment fragment = new AddNewCityFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, Constants.FRAGMENT);
        transaction.addToBackStack(Constants.FRAGMENT);
        transaction.commit();
    }
}
