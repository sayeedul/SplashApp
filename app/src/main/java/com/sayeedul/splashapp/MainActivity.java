package com.sayeedul.splashapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText user,pass,mail,gend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.login);
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        mail = (EditText)findViewById(R.id.email);
        gend = (EditText)findViewById(R.id.gender);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("MYPREF",MODE_PRIVATE);
                String U =user.getText().toString();
                String P = pass.getText().toString();
                String M = mail.getText().toString();
                String G = gend.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("user2",U);
                editor.putString("pass2",P);
                editor.putString("mail2",M);
                editor.putString("gend2",G);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
