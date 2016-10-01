package com.example.mprasher.foodbuddy.webservices.endpoints;

import com.example.mprasher.foodbuddy.webservices.models.LoginRequest;
import com.example.mprasher.foodbuddy.webservices.response.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface SignIn {
    @POST(EndPoints.Registeration.LOGIN_URL)
    Call<SignInResponse> signIn(@Body LoginRequest loginRequest);
}
