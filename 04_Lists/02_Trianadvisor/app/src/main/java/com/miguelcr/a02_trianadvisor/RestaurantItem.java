package com.miguelcr.a02_trianadvisor;

/**
 * Created by miguelcampos on 27/2/17.
 */

public class RestaurantItem {
    private String name;
    private String description;
    private float rating;
    private String urlPhoto;
    private String price;

    public RestaurantItem(String name, String description, float rating, String urlPhoto, String price) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.urlPhoto = urlPhoto;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
