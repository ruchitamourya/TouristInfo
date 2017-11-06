package com.example.ruchita.touristinfoapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ruchita.touristinfoapp.Data.CommonUtils;
import com.example.ruchita.touristinfoapp.Data.ExternalStorage;
import com.example.ruchita.touristinfoapp.Data.InternalStorage;


public class SplashActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(checkPermission()) {
            openNextActivity();
        }
    }

    private void openNextActivity() {
        ExternalStorage.getInstance(this).updateDataWithHardCodedData();
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

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openNextActivity();

                } else {
                    //Show user a dialog that we can't move ahead without this permission.
                    // On 'OK' check permission again, on 'quit' close the app
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("We need to save data of cities on your external storage. Without this permission, app can't work.\n" +
                            "Please provide the access.")
                            .setTitle("Permission Request")
                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checkPermission();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        }
    }
}

