package com.example.mprasher.foodbuddy.webservices.queries;

import com.example.mprasher.foodbuddy.webservices.endpoints.EndPoints;
import com.example.mprasher.foodbuddy.webservices.endpoints.WallListRequest;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.GetPostfailed;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.GetPostsSuccess;
import com.example.mprasher.foodbuddy.webservices.response.PostResponse;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mprasher on 2016-10-01.
 */

public class GetWallPostsQuery {

    private Retrofit retrofit;

    public GetWallPostsQuery() {
        Interceptor requestIntercerptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder()
                        .addHeader("content-type","application/json")
                        .addHeader("accept", "application/json");
                Request overridenRequest = requestBuilder.build();
                return chain.proceed(overridenRequest);
            }
        };
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client =  new OkHttpClient.Builder()
                .addInterceptor(requestIntercerptor)
                .addNetworkInterceptor(loggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(EndPoints.POST_ELASTIC_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getPosts(){
        WallListRequest wallListRequest = retrofit.create(WallListRequest.class);
        wallListRequest.getPosts().enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new GetPostsSuccess(response.body().getHits().getHits()));
                }else {
                    EventBus.getDefault().post(new GetPostfailed("Something Went Wrong"));
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                EventBus.getDefault().post(new GetPostfailed("Something Went Wrong"));
            }
        });
    }

}
