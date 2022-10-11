package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class home extends AppCompatActivity implements View.OnClickListener{
    private TextView profile, listgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profile = findViewById(R.id.tvProfile);
        listgame = findViewById(R.id.tvListgame);
        findViewById(R.id.tvProfile).setOnClickListener(this);
        findViewById(R.id.tvListgame).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tvProfile) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.tvListgame){
            Intent intent = new Intent(this, Listview.class);
            startActivity(intent);
        }
    }
}