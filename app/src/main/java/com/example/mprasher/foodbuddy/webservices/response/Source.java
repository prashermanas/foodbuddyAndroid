
package com.example.mprasher.foodbuddy.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("food_types")
    @Expose
    private String foodTypes;
    @SerializedName("pickup_address")
    @Expose
    private String pickupAddress;
    @SerializedName("is_drop_off")
    @Expose
    private Boolean isDropOff;
    @SerializedName("expire_time")
    @Expose
    private String expireTime;
    @SerializedName("promised")
    @Expose
    private Boolean promised;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     *     The user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return
     *     The foodTypes
     */
    public String getFoodTypes() {
        return foodTypes;
    }

    /**
     * 
     * @param foodTypes
     *     The food_types
     */
    public void setFoodTypes(String foodTypes) {
        this.foodTypes = foodTypes;
    }

    /**
     * 
     * @return
     *     The pickupAddress
     */
    public String getPickupAddress() {
        return pickupAddress;
    }

    /**
     * 
     * @param pickupAddress
     *     The pickup_address
     */
    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    /**
     * 
     * @return
     *     The isDropOff
     */
    public Boolean getIsDropOff() {
        return isDropOff;
    }

    /**
     * 
     * @param isDropOff
     *     The is_drop_off
     */
    public void setIsDropOff(Boolean isDropOff) {
        this.isDropOff = isDropOff;
    }

    /**
     * 
     * @return
     *     The expireTime
     */
    public String getExpireTime() {
        return expireTime;
    }

    /**
     * 
     * @param expireTime
     *     The expire_time
     */
    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 
     * @return
     *     The promised
     */
    public Boolean getPromised() {
        return promised;
    }

    /**
     * 
     * @param promised
     *     The promised
     */
    public void setPromised(Boolean promised) {
        this.promised = promised;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
