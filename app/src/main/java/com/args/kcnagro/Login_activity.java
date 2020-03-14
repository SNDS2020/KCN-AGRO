package com.args.kcnagro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_activity extends AppCompatActivity {

    EditText email, password;
    Button login;
    FirebaseAuth mfirebaseauth;
    private  FirebaseAuth.AuthStateListener mauthlistener;
    FirebaseUser user;

    TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);


        // assigning the blocks to variables
        email= findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.login_button);

        //forgot password button
        forgot_password = findViewById(R.id.forgot_pass);

        mauthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            // if the user is already logged in
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
             user = mfirebaseauth.getCurrentUser();//retriving the current user
             if(user!= null){
                 Intent intohome= new Intent(Login_activity.this,home_activity.class);
                 startActivity(intohome);
                 finish();

             }

            }
        };


        //firebase authentication instance
        mfirebaseauth = FirebaseAuth.getInstance();



        // when login button is clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailid = email.getText().toString();
                String pwd= password.getText().toString();

                if(emailid.isEmpty()){
                    email.setError("Email field is empty");
                    email.requestFocus();

                }
                else if(pwd.isEmpty()){
                    password.setError("Password field is empty");
                    email.requestFocus();

                }
                else if(emailid.isEmpty() && pwd.isEmpty()){//both fields are empty

                    Toast.makeText(Login_activity.this, "Both fields are empty!", Toast.LENGTH_SHORT).show();
                }

                else if(!(emailid.isEmpty()&& pwd.isEmpty())){
                    // both fields are filled

                    mfirebaseauth.signInWithEmailAndPassword(emailid,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) {
                                Toast.makeText(Login_activity.this, "Logged in sucessfully!", Toast.LENGTH_SHORT).show();
                                Intent into = new Intent(Login_activity.this, home_activity.class);
                                startActivity(into);
                                finish();
                            }
                            else {
                                Toast.makeText(Login_activity.this, "UNAUTHORIZED USER", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }


            }
        });
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(Login_activity.this,Forgot_password_activity.class);
                startActivity(forgot);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mfirebaseauth.addAuthStateListener(mauthlistener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
