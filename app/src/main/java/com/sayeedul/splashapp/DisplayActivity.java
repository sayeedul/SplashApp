package com.sayeedul.splashapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    TextView userN,passW,emaiL,gendeR;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        userN = (TextView)findViewById(R.id.userTV);
        passW = (TextView)findViewById(R.id.passTV);
        emaiL = (TextView)findViewById(R.id.emailTV);
        gendeR = (TextView)findViewById(R.id.genderTV);
        log = (Button)findViewById(R.id.logout);

        SharedPreferences preferences = getSharedPreferences("MYPREF",MODE_PRIVATE);
        String A = preferences.getString("user2","");
        String B = preferences.getString("pass2","");
        String C = preferences.getString("mail2","");
        String D = preferences.getString("gend2","");

        userN.setText(A);
        passW.setText(B);
        emaiL.setText(C);
        gendeR.setText(D);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pf = getSharedPreferences("LOGIN",MODE_PRIVATE);
                SharedPreferences.Editor  edit1 = pf.edit();
                edit1.remove("USERNAME");
                edit1.remove("PASSWORD");
                edit1.commit();

                Toast.makeText(DisplayActivity.this, "LOGGED OUT SUCCESSFULLY !!! ", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(DisplayActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
