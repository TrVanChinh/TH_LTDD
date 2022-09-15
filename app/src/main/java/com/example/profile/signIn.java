package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signIn extends AppCompatActivity implements View.OnClickListener{

    private EditText name, password;
    private TextView Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        name = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        Signup = findViewById(R.id.tvSignup);
        findViewById(R.id.btnSignin).setOnClickListener(this);
        findViewById(R.id.tvSignup).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String ten = new String(name.getText().toString());
        String matkhau = new String(password.getText().toString());
        if(view.getId() == R.id.tvSignup) {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnSignin){
            if (ten.equals("Chinhtran") && matkhau.equals("1234"))
            {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
            else
                Toast.makeText(this, "Sai ten dang nhap hoac mat khau", Toast.LENGTH_SHORT).show();
            }

        }

}