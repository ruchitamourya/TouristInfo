package com.example.ruchita.touristinfoapp.Data;

import com.example.ruchita.touristinfoapp.Model.City;

import java.util.ArrayList;

/**
 * Created by Ruchita on 15/10/17.
 */
// A Interface to provide the data of cities.
public interface DataProvider {
    // A method to get the cities.
    ArrayList<City> getCities();

    String updateCity(City city);

    // A method to add an extra city.
    void addCity(City city);

    void deleteCity(City city);
}
