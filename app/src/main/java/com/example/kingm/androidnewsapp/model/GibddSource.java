package com.example.kingm.androidnewsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kingm on 07.02.2018.
 */

public class GibddSource {
    //Serialisable name
    @SerializedName("CODE")
    private Long code;
    private String name;
    private Long index;
    private String address;
    private String phone;

    public GibddSource(Long code, String name, Long index, String address, String phone) {
        this.code = code;
        this.name = name;
        this.index = index;
        this.address = address;
        this.phone = phone;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
