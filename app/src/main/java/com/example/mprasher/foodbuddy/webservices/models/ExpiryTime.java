package com.example.mprasher.foodbuddy.webservices.models;


import com.google.gson.annotations.SerializedName;

public class ExpiryTime {
    @SerializedName("expire_time")
    private String expiryTime;

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }
}
