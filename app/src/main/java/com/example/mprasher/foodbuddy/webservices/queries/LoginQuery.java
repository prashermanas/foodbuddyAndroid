package com.example.mprasher.foodbuddy.webservices.queries;

import com.example.mprasher.foodbuddy.webservices.endpoints.RegisterationInterface;
import com.example.mprasher.foodbuddy.webservices.endpoints.SignIn;
import com.example.mprasher.foodbuddy.webservices.events.SignInSuccess;
import com.example.mprasher.foodbuddy.webservices.events.SignInfailed;
import com.example.mprasher.foodbuddy.webservices.models.LoginRequest;
import com.example.mprasher.foodbuddy.webservices.models.RegisterationRequest;
import com.example.mprasher.foodbuddy.webservices.response.SignInResponse;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mprasher on 2016-10-01.
 */

public class LoginQuery extends BaseQuery {

    public LoginQuery(LoginRequest registerationRequest) {
        SignIn signIn = retrofit.create(SignIn.class);
        signIn.signIn(registerationRequest).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new SignInSuccess(response.body().getUser()));
                }else {
                    EventBus.getDefault().post(new SignInfailed("Something Went Wrong"));
                }
            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                EventBus.getDefault().post(new SignInfailed("Something Went Wrong"));
            }
        });
    }
}
