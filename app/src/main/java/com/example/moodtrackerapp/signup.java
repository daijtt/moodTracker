package com.example.moodtrackerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    EditText fullName , email ,username , password  ;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        actionBar = getSupportActionBar();
        actionBar.hide();

        // Assign user variables
        fullName = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.userEmail);
        password = (EditText) findViewById(R.id.password);

    }
    public void SignUp(View view){
        //Registration and create a new account
        // if the username is used make an error toast message

        Intent i = new Intent(this , Setting.class);
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
//        startActivity(i, ActivityOptions.makeThumbnailScaleUpAnimation(this).toBundle());
    }


    public void MoveToSignIn(View view ){
        Intent signIn = new Intent(this , signIn.class);
        startActivity(signIn);

    }
}