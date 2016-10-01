package com.example.mprasher.foodbuddy.webservices.events;

import com.example.mprasher.foodbuddy.webservices.response.User;

/**
 * Created by mprasher on 2016-10-01.
 */

public class SignInSuccess {
    private User user;

    public SignInSuccess(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
