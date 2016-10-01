package com.example.mprasher.foodbuddy.webservices.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mprasher on 2016-10-01.
 */

public class User {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("user_type")
    private String userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
