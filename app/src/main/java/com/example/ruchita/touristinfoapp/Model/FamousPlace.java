package com.example.ruchita.touristinfoapp.Model;

/**
 * Created by Ruchita on 26/9/17.
 */
// A model class for famous place.
public class FamousPlace {
    // Properties of class FamousPlaces.
    private String title;
    private String description;
    private double latitude;
    private double longitude;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
