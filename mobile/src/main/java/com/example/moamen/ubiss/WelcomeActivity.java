package com.example.moamen.ubiss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }


    public void startTask(View view) {
        Intent intent = new Intent(this, Connectmyo.class);
        startActivity(intent);
    }



}

