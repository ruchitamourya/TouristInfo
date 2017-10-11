package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_login;
    private EditText user_name;
    private EditText password;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_login = (Button)findViewById(R.id.button_login);
        user_name = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.password);


        button_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CityListActivity.class);
        if(user_name.getText().toString().equals("user") &&
                password.getText().toString().equals("1234")) {
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this,"username or password is wrong",Toast.LENGTH_SHORT).show();
        }

    }
}