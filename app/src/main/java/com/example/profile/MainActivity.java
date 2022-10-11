package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnlogout).setOnClickListener(this);
        findViewById(R.id.iconback).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnlogout) {
            Intent intent = new Intent(this, signIn.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.iconback) {
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        }
    }
}