package com.args.kcnagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Account_activity extends AppCompatActivity {

    TextView email;
    Button logout_button;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mfirebaseuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_activity);

        email= findViewById(R.id.email_display);
        logout_button = findViewById(R.id.logout_but);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mfirebaseuser = mFirebaseAuth.getCurrentUser();

        String email_account_id = mfirebaseuser.getEmail();

        email.setText(email_account_id);

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent logout = new Intent(Account_activity.this,Login_activity.class);
                startActivity(logout);
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
