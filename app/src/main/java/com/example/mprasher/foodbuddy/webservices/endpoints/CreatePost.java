package com.example.mprasher.foodbuddy.webservices.endpoints;


import com.example.mprasher.foodbuddy.webservices.models.CreatePostRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CreatePost {
    @POST(EndPoints.PostCreate.POST_CREATE_URL)
    Call<Void> createPost(@Body CreatePostRequest createPostRequest);
}
