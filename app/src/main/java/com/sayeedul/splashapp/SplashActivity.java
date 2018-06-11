package com.sayeedul.splashapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIMOUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {

                 SharedPreferences pf = getSharedPreferences("LOGIN",MODE_PRIVATE);
                 if(pf.contains("USERNAME") && pf.contains("PASSWORD")) {

                     Toast.makeText(SplashActivity.this, "WELCOME BACK "+pf.getString("USERNAME",""), Toast.LENGTH_SHORT).show();
                     Intent i = new Intent(SplashActivity.this, DisplayActivity.class);
                     startActivity(i);
                 }
                 else
                 {
                     Toast.makeText(SplashActivity.this, "LOGIN AGAIN....PLZ WAIT>>>", Toast.LENGTH_SHORT).show();
                     Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                     startActivity(i);
                 }
                 finish();
             }
         },SPLASH_TIMOUT);
    }
}
