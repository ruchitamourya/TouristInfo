package com.example.ruchita.touristinfoapp;

import android.view.View;

import com.example.ruchita.touristinfoapp.Model.City;

/**
 * Created by Ruchita on 05-10-2017.
 */
/*
 *Interface to perform a click .
  */
public interface ItemClickListener {
    void onItemClick(View view, City data);
}
