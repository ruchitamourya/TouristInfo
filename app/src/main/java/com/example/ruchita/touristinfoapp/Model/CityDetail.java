package com.example.ruchita.touristinfoapp.Model;

/**
 * Created by Ruchita on 23/9/17.
 */
// A model class for city detail.
public class CityDetail {
    // Properties of class CityDetail.
    private int imageId;
    private String imagePath;
    private String description;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
