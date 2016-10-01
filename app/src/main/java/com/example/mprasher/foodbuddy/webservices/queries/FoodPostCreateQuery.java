package com.example.mprasher.foodbuddy.webservices.queries;

import com.example.mprasher.foodbuddy.webservices.endpoints.CreatePost;
import com.example.mprasher.foodbuddy.webservices.events.RegisterationFailed;
import com.example.mprasher.foodbuddy.webservices.events.RegisterationSuccess;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.PostFailed;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.PostSuccess;
import com.example.mprasher.foodbuddy.webservices.models.CreatePostRequest;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FoodPostCreateQuery extends BaseQuery {

    public void createPost(CreatePostRequest createPostRequest){

        CreatePost createPost = retrofit.create(CreatePost.class);
        createPost.createPost(createPostRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new PostSuccess());
                }else {
                    EventBus.getDefault().post(new PostFailed("Something Went Wrong"));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                EventBus.getDefault().post(new PostFailed(t.getMessage()));
            }
        });

    }
}
