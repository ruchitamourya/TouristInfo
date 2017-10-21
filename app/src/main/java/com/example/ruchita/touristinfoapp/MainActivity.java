package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_login;
    private EditText user_name;
    private EditText password;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_login = (Button) findViewById(R.id.button_login);
        user_name = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tourist Info");
            button_login.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CityListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        if (user_name.getText().toString().equals("user") &&
                password.getText().toString().equals("1234")) {
            SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_KEY, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Constants.IS_LOGGED_IN, true);
            editor.apply();
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "username or password is wrong", Toast.LENGTH_SHORT).show();
        }
    }
}