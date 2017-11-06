package com.example.ruchita.touristinfoapp.Model;

import java.util.ArrayList;

/**
 * Created by Ruchita on 22/9/17.
 */
/*
 *Model class for cities.
 */
public class City {
    /*
     *Properties of class City.
      */
    private String cityId;
    private String cityName;
    private CityDetail cityDetail;
    private ArrayList<FamousPlace> famousPlaceList;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CityDetail getCityDetail() {
        return cityDetail;
    }

    public void setCityDetail(CityDetail cityDetail) {
        this.cityDetail = cityDetail;
    }


    public ArrayList<FamousPlace> getFamousPlaceList() {
        return famousPlaceList;
    }

    public void setFamousPlaceList(ArrayList<FamousPlace> famousPlaceList) {
        this.famousPlaceList = famousPlaceList;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}

