package com.example.mprasher.foodbuddy.regsteration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mprasher.foodbuddy.R;
import com.example.mprasher.foodbuddy.create_post.CreatePostScreen;
import com.example.mprasher.foodbuddy.utils.FoodBuddyPrefs;
import com.example.mprasher.foodbuddy.utils.VerificationUtils;
import com.example.mprasher.foodbuddy.webservices.events.SignInSuccess;
import com.example.mprasher.foodbuddy.webservices.events.SignInfailed;
import com.example.mprasher.foodbuddy.webservices.models.LoginRequest;
import com.example.mprasher.foodbuddy.webservices.queries.LoginQuery;
import com.example.mprasher.foodbuddy.webservices.response.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogIn extends AppCompatActivity {

    @BindView(R.id.emailLogin) EditText emailLogin;
    @BindView(R.id.passwordLogin)EditText password;
    private FoodBuddyPrefs foodBuddyPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        foodBuddyPrefs = new FoodBuddyPrefs(this);
        registerEventBus();
    }

    private void registerEventBus(){
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    private void unregisterEventBus(){
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSignInSuccess(SignInSuccess signInSuccess){
        showToastMessage("Signed In Successfully");
        User user = signInSuccess.getUser();
        foodBuddyPrefs.setUserId(user.getUserId());
        foodBuddyPrefs.setIsLoggin(true);
        finish();

        Intent intent = new Intent(this, CreatePostScreen.class);
        startActivity(intent);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSignInFailed(SignInfailed signInfailed){
        showToastMessage(signInfailed.getMessage());
    }

    private void showToastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        unregisterEventBus();
        super.onStop();
    }

    @OnClick(R.id.email_sign_in_button)
    public void login(){
       if(VerificationUtils
               .isValidEmail(emailLogin.getText().toString()) || !password.getText().toString().isEmpty()){
           LoginRequest loginRequest = new LoginRequest();
           loginRequest.setPassword("1234");
           loginRequest.setEmail("mprasher@gasbuddy.com");
           new LoginQuery(loginRequest);
        }
    }
}
