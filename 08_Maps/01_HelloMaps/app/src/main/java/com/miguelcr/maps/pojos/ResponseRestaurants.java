
package com.miguelcr.maps.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRestaurants {

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("restaurants")
    @Expose
    private List<Restaurant> restaurants = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseRestaurants() {
    }

    /**
     * 
     * @param error
     * @param restaurants
     */
    public ResponseRestaurants(boolean error, List<Restaurant> restaurants) {
        super();
        this.error = error;
        this.restaurants = restaurants;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResponseRestaurants withError(boolean error) {
        this.error = error;
        return this;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public ResponseRestaurants withRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }

}
