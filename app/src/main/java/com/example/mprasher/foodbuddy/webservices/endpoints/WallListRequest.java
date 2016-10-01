package com.example.mprasher.foodbuddy.webservices.endpoints;

import com.example.mprasher.foodbuddy.webservices.response.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mprasher on 2016-10-01.
 */

public interface WallListRequest {
    @GET(EndPoints.PostCreate.GET_POST_URL)
    Call<PostResponse> getPosts();

}
