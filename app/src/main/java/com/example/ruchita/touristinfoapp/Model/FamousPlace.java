package com.example.ruchita.touristinfoapp.Model;

/**
 * Created by ruchita on 26/9/17.
 */

public class FamousPlace {

    private String title;
    private String description;
    private int imgResourceId;
    private int googleImgResourceId;

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

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public int getGoogleImgResourceId() {
        return googleImgResourceId;
    }

    public void setGoogleImgResourceId(int googleImgResourceId) {
        this.googleImgResourceId = googleImgResourceId;
    }
}
