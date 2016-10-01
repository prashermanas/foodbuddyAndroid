package com.example.mprasher.foodbuddy.webservices.events;


public class SignInfailed {
    private String message;

    public SignInfailed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
