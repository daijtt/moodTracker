package com.example.moodtrackerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar; Animation logoAnim, signAnim; ImageView logo;
    Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.hide();

        logo = (ImageView) findViewById(R.id.logo);
        signIn = (Button) findViewById(R.id.signInBtn);
        signUp = (Button) findViewById(R.id.signUpBtn);
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        signAnim = AnimationUtils.loadAnimation(this, R.anim.sign_anim);

        logo.startAnimation(logoAnim);
        signIn.startAnimation(signAnim);
        signUp.startAnimation(signAnim);
    }

    public void signIn(View V){
        Intent i = new Intent(this,signIn.class);
        startActivity(i);
    }

    public void signUp(View V){
        Intent i = new Intent(this,signup.class);
        startActivity(i);
    }

    public void mainPage(View V){
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i);
    }

    public void goSetting(View v) {
        Intent i = new Intent(this,Setting.class);
        startActivity(i);
    }

    public void goTimeLine(View v) {
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i);
    }

    public void goSessions(View v) {
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i);
    }
}