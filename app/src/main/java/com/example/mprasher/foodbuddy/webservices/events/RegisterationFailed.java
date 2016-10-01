package com.example.mprasher.foodbuddy.webservices.events;

/**
 * Created by mprasher on 2016-10-01.
 */

public class RegisterationFailed {
    private String message;

    public RegisterationFailed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
