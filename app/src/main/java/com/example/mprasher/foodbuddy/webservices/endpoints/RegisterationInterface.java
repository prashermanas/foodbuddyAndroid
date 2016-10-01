package com.example.mprasher.foodbuddy.webservices.endpoints;


import com.example.mprasher.foodbuddy.webservices.endpoints.EndPoints;
import com.example.mprasher.foodbuddy.webservices.models.RegisterationRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterationInterface {
    @POST(EndPoints.Registeration.REGISTERATION_URL)
    Call<Void> register(@Body RegisterationRequest registerationRequest);
}
