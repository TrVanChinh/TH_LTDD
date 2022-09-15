package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signup extends AppCompatActivity implements View.OnClickListener {
    private TextView Signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Signin = findViewById(R.id.tvSignin);
        findViewById(R.id.tvSignin).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tvSignin) {
            Intent intent = new Intent(this, signIn.class);
            startActivity(intent);
        }
    }
}