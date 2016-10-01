package com.example.mprasher.foodbuddy.webservices.queries;


import com.example.mprasher.foodbuddy.webservices.endpoints.RegisterationInterface;
import com.example.mprasher.foodbuddy.webservices.events.RegisterationFailed;
import com.example.mprasher.foodbuddy.webservices.events.RegisterationSuccess;
import com.example.mprasher.foodbuddy.webservices.models.RegisterationRequest;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterationQuery extends BaseQuery{

    public RegisterationQuery(RegisterationRequest registerationRequest) {
        RegisterationInterface registerationInterface = retrofit.create(RegisterationInterface.class);

        registerationInterface.register(registerationRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new RegisterationSuccess());
                }
                else {
                    EventBus.getDefault().post(new RegisterationFailed("Something Went Wrong"));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                EventBus.getDefault().post(new RegisterationFailed("Something Went Wrong"));
            }
        });
    }
}
