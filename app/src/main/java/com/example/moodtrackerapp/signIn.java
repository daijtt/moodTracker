package com.example.moodtrackerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moodtrackerapp.R;

public class signIn extends AppCompatActivity {
    ActionBar actionBar;
    EditText username , password ;
    Button loginButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        actionBar = getSupportActionBar();
        actionBar.hide();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }
    public void SignIn(View view) {

        //Validation
        if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")){
            Toast.makeText(this, "login successfully ", Toast.LENGTH_SHORT).show();

            GoToSetting(view);

            ////////////////////////////
            /////// go to profile page //////////
            /////////////////////////////

        }else {
            Toast.makeText(this, "login failed ", Toast.LENGTH_SHORT).show();
        }
    }
    public void MoveToSignUp(View view){
        Intent signup = new Intent(this , signup.class);
        startActivity(signup);
    }
    public void GoToSetting(View view){
        Intent setting = new Intent(this , Setting.class);
        startActivity(setting);
    }


}