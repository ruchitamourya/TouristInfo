package com.example.ruchita.touristinfoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ruchita on 4/10/17.
 */

public class AddNewCityFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.add_new_city_fragment, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
