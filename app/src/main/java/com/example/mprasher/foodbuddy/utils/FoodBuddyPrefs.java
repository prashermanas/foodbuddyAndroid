package com.example.mprasher.foodbuddy.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class FoodBuddyPrefs {
    public static final String TAG = FoodBuddyPrefs.class.getCanonicalName();
    public static final String IS_LOGGED_IN = "IS_LOGGED_IN";
    public static final boolean DEF_BOOLEAN = false;
    public static final String USER_ID = "USER_ID";
    public static final String DEF_STRING = "";
    public static final String USER_NAME = "USER_NAME";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String FOOD_BUDDY_PREFS = "FOOD_BUDDY_PREFS";

    public FoodBuddyPrefs(Context context) {
        this.sharedPreferences = context.getSharedPreferences(FOOD_BUDDY_PREFS,Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }


    public void setIsLoggin(boolean value){
        editor.putBoolean(IS_LOGGED_IN,value);
        editor.apply();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, DEF_BOOLEAN);
    }

    public void setUserId(String userId){
        editor.putString(USER_ID,userId);
        editor.apply();
    }

    public String getUserId(){
        return sharedPreferences.getString(USER_ID, DEF_STRING);
    }


    public void setUserName(String userName) {
        editor.putString(USER_NAME,userName);
        editor.apply();
    }

    public String getUserName(){
        return sharedPreferences.getString(USER_NAME,DEF_STRING);
    }
}
