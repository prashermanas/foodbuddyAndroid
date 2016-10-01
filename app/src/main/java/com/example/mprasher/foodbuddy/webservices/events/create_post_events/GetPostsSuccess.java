package com.example.mprasher.foodbuddy.webservices.events.create_post_events;

import com.example.mprasher.foodbuddy.webservices.response.Hit;
import com.example.mprasher.foodbuddy.webservices.response.Hits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mprasher on 2016-10-01.
 */

public class GetPostsSuccess {
    private List<Hit> hits;

    public GetPostsSuccess(List<Hit> hits) {
        this.hits = hits;
    }

    public List<Hit> getHits() {
        return hits;
    }
}
