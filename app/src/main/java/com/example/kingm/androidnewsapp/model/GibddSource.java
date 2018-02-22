package com.example.kingm.androidnewsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by kingm on 07.02.2018.
 */


public class GibddSource extends SugarRecord {

    private Long idFromJson;
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

    public Long getIdFromJson() {
        return idFromJson;
    }

    public void setIdFromJson(Long idFromJson) {
        this.idFromJson = idFromJson;
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

    public void changeFavourite() {
        if (isFavourite()) {
            this.favourite = false;
        } else {
            this.favourite = true;
        }
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

}
