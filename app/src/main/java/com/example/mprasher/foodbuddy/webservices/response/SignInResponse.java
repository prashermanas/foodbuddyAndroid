package com.example.mprasher.foodbuddy.webservices.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mprasher on 2016-10-01.
 */

public class SignInResponse {
      @SerializedName("user")
      private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
