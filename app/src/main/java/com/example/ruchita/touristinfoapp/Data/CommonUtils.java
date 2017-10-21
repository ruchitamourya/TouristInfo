package com.example.ruchita.touristinfoapp.Data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.ruchita.touristinfoapp.Constants;
import com.example.ruchita.touristinfoapp.SplashActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Chandan on 21-10-2017.
 */

public class CommonUtils {
    private static final String LAUNCH_COUNT = "launchcount";
    public static int getLaunchCount(Context context){
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
        int count = preferences.getInt(LAUNCH_COUNT, 0);
        return count;
    }
    public static void incrementLaunchCount(Context context){
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
        int count = preferences.getInt(LAUNCH_COUNT, 0);
        count++;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(LAUNCH_COUNT, count);
        editor.apply();
    }

    public static void logout(AppCompatActivity activity) {
        Intent intent = new Intent(activity, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        SharedPreferences sharedPreferences = activity.getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants.IS_LOGGED_IN, false);
        editor.apply();
        activity.startActivity(intent);
    }
}
