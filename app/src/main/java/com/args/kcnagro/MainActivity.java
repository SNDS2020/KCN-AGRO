package com.args.kcnagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.sax.StartElementListener;

public class MainActivity extends AppCompatActivity {
    public int SPLASH_TIME_OUT=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(MainActivity.this,Login_activity.class);
                startActivity(login);
                finish(); //splash activity ends in a second
            }
        },SPLASH_TIME_OUT);// specifies the amount of time to splash the screen
    }
}
