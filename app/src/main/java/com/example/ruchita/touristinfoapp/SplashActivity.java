package com.example.ruchita.touristinfoapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ruchita.touristinfoapp.Data.CommonUtils;
import com.example.ruchita.touristinfoapp.Data.InternalStorage;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InternalStorage.getInstance(this).updateDataWithHardCodedData();
        CommonUtils.incrementLaunchCount(this);
        boolean isLoggedIn = checkLogin();
        Intent intent;
        if (isLoggedIn) {
            intent = new Intent(this, CityListActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

    // A method to check if login or not.
    private boolean checkLogin() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
        boolean loggedIn = sharedPreferences.getBoolean(Constants.IS_LOGGED_IN, false);
        return loggedIn;
    }
}

