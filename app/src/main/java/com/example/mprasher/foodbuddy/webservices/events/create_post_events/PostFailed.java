package com.example.mprasher.foodbuddy.webservices.events.create_post_events;

/**
 * Created by mprasher on 2016-10-01.
 */

public class PostFailed {
    private String errorMessage;


    public PostFailed(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
