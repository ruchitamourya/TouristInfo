package com.example.ruchita.touristinfoapp.Data;

import com.example.ruchita.touristinfoapp.Model.City;

import java.util.ArrayList;

/**
 * Created by Ruchita on 15/10/17.
 */

public interface DataProvider {
    ArrayList<City> getCities();
    String updateCity(City city);
    String addCity(City city);
    String deleteCity(City city);
}
