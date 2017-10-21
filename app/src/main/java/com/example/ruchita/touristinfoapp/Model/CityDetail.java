package com.example.ruchita.touristinfoapp.Model;

/**
 * Created by ruchita on 23/9/17.
 */

public class CityDetail {

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
