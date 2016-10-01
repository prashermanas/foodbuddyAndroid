package com.example.mprasher.foodbuddy.webservices.queries;

import com.example.mprasher.foodbuddy.webservices.endpoints.EndPoints;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mprasher on 2016-10-01.
 */

public abstract class BaseQuery {

    protected Retrofit retrofit;

    public BaseQuery() {
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
                .baseUrl(EndPoints.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
