package com.example.mprasher.foodbuddy.webservices.events.create_post_events;

/**
 * Created by mprasher on 2016-10-01.
 */

public class GetPostfailed {
    private String message;

    public GetPostfailed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
