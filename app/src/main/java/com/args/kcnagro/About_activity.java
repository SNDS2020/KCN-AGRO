package com.args.kcnagro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class About_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_activity);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
