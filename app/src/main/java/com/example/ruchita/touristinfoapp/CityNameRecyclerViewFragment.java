package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruchita.touristinfoapp.Adapter.CityGridAdapter;
import com.example.ruchita.touristinfoapp.Data.DataProvider;
import com.example.ruchita.touristinfoapp.Data.ExternalStorage;
import com.example.ruchita.touristinfoapp.Data.FileDataProvider;
import com.example.ruchita.touristinfoapp.Data.InternalStorage;
import com.example.ruchita.touristinfoapp.Model.City;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Ruchita on 5/10/17.
 */

public class CityNameRecyclerViewFragment extends Fragment implements ItemClickListener {

    //Field variables of class CityNameRecyclerViewFragment.

    private FragmentManager mFragmentManager;
    private DataProvider mDataProvider;

    //Default constructor of class CityNameRecyclerViewFragment.

    public CityNameRecyclerViewFragment() {
        mDataProvider = ExternalStorage.getInstance(this.getContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.city_name_recyclerview_fragment, container, false);
        setUpRecyclerView(view);
        mFragmentManager = getFragmentManager();
        return view;
    }

    /*
     * Method to set recyclerView on CityNameRecyclerViewFragment class.
      */
    private void setUpRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        ArrayList<City> data = mDataProvider.getCities();
        CityGridAdapter adapter = new CityGridAdapter(getActivity(), this, data);

        recyclerView.setAdapter(adapter);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mGridLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onItemClick(View view, City current) {
        if (view.getId() == R.id.cardView) {
            if (!current.getCityName().equals(Constants.ADD_NEW_CITY)) {
                openDetailsActivity(current);
            } else {
                addNewCityFragment();
            }
        }
    }

    /*
     *Method to open DetailActivity class.
     */
    private void openDetailsActivity(City current) {
        String data;
        Intent intent = new Intent(getActivity(), CityDetailPageActivity.class);
        Gson gson = new Gson();
        data = gson.toJson(current);
        intent.putExtra(Constants.CITY_DATA, data);
        startActivity(intent);
    }

    /*
     *Method to set a new fragment on CityNameRecyclerViewFragment class.
     */
    public void addNewCityFragment() {
        AddNewCityFragment fragment = new AddNewCityFragment();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, Constants.FRAGMENT);
        transaction.addToBackStack(Constants.FRAGMENT);
        transaction.commit();
    }
}
