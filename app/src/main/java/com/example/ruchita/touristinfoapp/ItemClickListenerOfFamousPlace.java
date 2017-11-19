package com.example.ruchita.touristinfoapp;

import android.view.View;

import com.example.ruchita.touristinfoapp.Model.FamousPlace;

/**
 * Created by Ruchita on 15/10/17.
 */

//Interface to perform a click on famous places class item.
public interface ItemClickListenerOfFamousPlace {

    void onItemClick(View view, FamousPlace famousPlace);
}
