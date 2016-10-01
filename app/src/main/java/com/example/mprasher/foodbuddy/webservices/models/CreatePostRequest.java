package com.example.mprasher.foodbuddy.webservices.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CreatePostRequest {
    @SerializedName("title")
    private String title;
    @SerializedName("food_types")
    private String foodTypes;
    @SerializedName("pickup_address")
    private String postPickupLocation;
    @SerializedName("is_drop_off")
    private boolean isDroppingOff;
    @SerializedName("expire_time")
    private String expireTime;
    @SerializedName("description")
    private String description;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("promised")
    private boolean promised;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isPromised() {
        return promised;
    }

    public void setPromised(boolean promised) {
        this.promised = promised;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(String foodTypes) {
        this.foodTypes = foodTypes;
    }

    public String getPostPickupLocation() {
        return postPickupLocation;
    }

    public void setPostPickupLocation(String postPickupLocation) {
        this.postPickupLocation = postPickupLocation;
    }

    public boolean isDroppingOff() {
        return isDroppingOff;
    }

    public void setDroppingOff(boolean droppingOff) {
        isDroppingOff = droppingOff;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
