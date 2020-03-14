package com.args.kcnagro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_password_activity extends AppCompatActivity {


    EditText email;
    Button button;
    FirebaseAuth mfirebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_activity);

        email = findViewById(R.id.forgot_email);
        button = findViewById(R.id.forgot_button);
        mfirebaseauth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String forgot_email_id = email.getText().toString();

                if(forgot_email_id.isEmpty()){
                    email.setError("Please enter an email");
                    email.requestFocus();
                }
                else if(!(forgot_email_id.isEmpty())){

                    mfirebaseauth.sendPasswordResetEmail(forgot_email_id).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Forgot_password_activity.this, "Reset email sent sucessfully", Toast.LENGTH_SHORT).show();
                                email.setText("");
                            }
                            else if(!(task.isSuccessful())){
                                Toast.makeText(Forgot_password_activity.this, "ERROR", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });


    }
}
