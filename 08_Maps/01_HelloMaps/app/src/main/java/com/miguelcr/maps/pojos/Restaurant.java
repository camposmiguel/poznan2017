
package com.miguelcr.maps.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("latlng")
    @Expose
    private String latlng;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Restaurant() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param latlng
     */
    public Restaurant(String id, String latlng, String name) {
        super();
        this.id = id;
        this.latlng = latlng;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Restaurant withId(String id) {
        this.id = id;
        return this;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public Restaurant withLatlng(String latlng) {
        this.latlng = latlng;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant withName(String name) {
        this.name = name;
        return this;
    }

}
