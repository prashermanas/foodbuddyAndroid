package com.example.mprasher.foodbuddy.wall;


import com.example.mprasher.foodbuddy.webservices.models.ExpiryTime;
import com.google.gson.annotations.SerializedName;

public class WallRowModel {
    @SerializedName("user_name")
    private String userName;
    @SerializedName("title")
    private String title;
    @SerializedName("food_types")
    private String foodTypes;
    @SerializedName("expire_time")
    private String timeString;
    @SerializedName("pickup_address")
    private String pickUpLocation;
    @SerializedName("description")
    private String description;
    @SerializedName("is_drop_off")
    private boolean isDropOff;
    private ExpiryTime expiryTime;
    @SerializedName("promised")
    private boolean promised;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDropOff() {
        return isDropOff;
    }

    public void setDropOff(boolean dropOff) {
        isDropOff = dropOff;
    }

    public ExpiryTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(ExpiryTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public boolean isPromised() {
        return promised;
    }

    public void setPromised(boolean promised) {
        this.promised = promised;
    }


}
