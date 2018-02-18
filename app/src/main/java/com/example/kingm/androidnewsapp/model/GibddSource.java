package com.example.kingm.androidnewsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kingm on 07.02.2018.
 */

public class GibddSource {

    @SerializedName("id")
    private String id;
    @SerializedName("updated")
    private String updated;
    @SerializedName("value")
    private String value;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;

    private Boolean favourite;

    public GibddSource() {
        this.favourite = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public boolean isFavourite() {
        return this.favourite;
    }
    public void setFavourite(boolean favourite) {
         this.favourite = favourite;
    }

}
