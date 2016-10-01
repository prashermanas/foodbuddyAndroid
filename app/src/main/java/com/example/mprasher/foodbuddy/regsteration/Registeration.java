package com.example.mprasher.foodbuddy.regsteration;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mprasher.foodbuddy.R;
import com.example.mprasher.foodbuddy.create_post.CreatePostScreen;
import com.example.mprasher.foodbuddy.utils.FoodBuddyPrefs;
import com.example.mprasher.foodbuddy.utils.VerificationUtils;
import com.example.mprasher.foodbuddy.wall.WallScreen;
import com.example.mprasher.foodbuddy.webservices.endpoints.CreatePost;
import com.example.mprasher.foodbuddy.webservices.events.RegisterationFailed;
import com.example.mprasher.foodbuddy.webservices.events.RegisterationSuccess;
import com.example.mprasher.foodbuddy.webservices.models.RegisterationRequest;
import com.example.mprasher.foodbuddy.webservices.queries.RegisterationQuery;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;

public class Registeration extends AppCompatActivity {

    @BindView(R.id.userType)AppCompatSpinner userType;
    @BindView(R.id.name)EditText name;
    @BindView(R.id.email)EditText email;
    @BindView(R.id.password)EditText password;
    private FoodBuddyPrefs foodBuddyPrefs;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        ButterKnife.bind(this);
        foodBuddyPrefs = new FoodBuddyPrefs(this);
        registerEventBus();
    }

    @Override
    protected void onStop() {
        unregisterEventBus();
        super.onStop();
    }

    private void registerEventBus(){
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    private void unregisterEventBus(){
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.email_sign_in_button)
    public void onLogin(){
        String nameString = name.getText().toString();
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        if(!TextUtils.isEmpty(nameString)
                &&
                VerificationUtils.isValidEmail(emailString) && !TextUtils.isEmpty(passwordString)){
            RegisterationRequest registerationRequest = new RegisterationRequest();
            registerationRequest.setEmail(emailString);
            registerationRequest.setName(nameString);
            registerationRequest.setPassword(passwordString);
            registerationRequest.setUserType(getStringByIndex());
            new RegisterationQuery(registerationRequest);
        }else {
            if(TextUtils.isEmpty(nameString)){
                name.setError("Enter Your Name");
            }
            if(!VerificationUtils.isValidEmail(emailString)){
                email.setError("Enter a valid email address");
            }
            if(TextUtils.isEmpty(passwordString)){
                password.setError("Please enter a password");
            }
        }
    }

    private String getStringByIndex() {
        if(userType.getSelectedItemPosition()==0){
            return "individual";
        }else {
            return "organization";
        }
    }

    @OnClick(R.id.registerButton)
    public void register(){
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void registerationSuccess(RegisterationSuccess registerationSuccess){
        foodBuddyPrefs.setIsLoggin(true);
        foodBuddyPrefs.setUserName(name.getText().toString());
        showMessage("Registered Successfully");
        finish();
        Intent intent = new Intent(this,CreatePostScreen.class);
        startActivity(intent);
    }

    private void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void registerationFailed(RegisterationFailed registerationFailed){
        showMessage(registerationFailed.getMessage());
    }



}

