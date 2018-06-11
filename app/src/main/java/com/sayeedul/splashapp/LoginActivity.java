package com.sayeedul.splashapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{

    Button login,signup;
    EditText user,pwd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user =   (EditText)findViewById(R.id.username);
        pwd =    (EditText)findViewById(R.id.password1);
        login =  (Button)findViewById(R.id.login1);
        signup = (Button)findViewById(R.id.signup1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefereneces = getSharedPreferences("MYPREF",MODE_PRIVATE);
                String a = prefereneces.getString("user2","");
                String b = prefereneces.getString("pass2","");

                if( (user.getText().toString() == a) && (pwd.getText().toString()== b))
                {
                    SharedPreferences pf = getSharedPreferences("LOGIN",MODE_PRIVATE);
                    SharedPreferences.Editor edit = pf.edit();
                    edit.putString("USERNAME",a);
                    edit.putString("PASSWORD",b);
                    edit.commit();

                    Toast.makeText(LoginActivity.this, "LOGGED IN SUCCESSFULLY....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DisplayActivity.class);
                    startActivity(intent);
                   }

                else
                {
                    Toast.makeText(LoginActivity.this, "INCORRECT LOGIN DETAILS!!!", Toast.LENGTH_SHORT).show();
                }
              }
             });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
