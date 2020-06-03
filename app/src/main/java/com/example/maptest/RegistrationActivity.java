package com.example.maptest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class RegistrationActivity extends AppCompatActivity {


    private static final String TAG = "Registration";


    EditText userLogin, emailID, password;
    Button btnSignUP;
    TextView tvgoto_SignIN;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mFirebaseAuth = FirebaseAuth.getInstance();

        userLogin = findViewById(R.id.name_SignUP);
        emailID = findViewById(R.id.email_SignUP);
        password = findViewById(R.id.password_SignUP);
        btnSignUP = findViewById(R.id.button_signUP);
        tvgoto_SignIN = findViewById(R.id.text_goto_SignIN);

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userLog = userLogin.getText().toString();
                String email = emailID.getText().toString();
                String pwd = password.getText().toString();

                if (userLog.isEmpty()) {
                    userLogin.setError("Please enter the username!");
                    userLogin.requestFocus();
                    Log.d(TAG, "login 1 " + userLogin.getText().toString());
                }
                if (email.isEmpty()) {
                    emailID.setError("Please enter the E-mail!");
                    emailID.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter the password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty() && userLog.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show(); //всплывающее окно
                } else if (!(email.isEmpty() && pwd.isEmpty() && userLog.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {

                                Toast.makeText(RegistrationActivity.this, "Incorrect e-mail or password", Toast.LENGTH_SHORT).show();

                            } else {
                                Log.d(TAG, "login 2" + userLogin.getText().toString());
                                //  mFirebaseAuth.addAuthStateListener((FirebaseAuth.AuthStateListener) userLogin);
                                startActivity(new Intent(RegistrationActivity.this, MapActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegistrationActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }

                Log.d(TAG, "login " + userLogin.getText().toString());
                Intent intent = new Intent(RegistrationActivity.this, ProfileActiivity.class);
                intent.putExtra("email_for_profile", emailID.getText().toString());
                intent.putExtra("username", userLogin.getText().toString());
                // startActivity(intent);


                Log.d(TAG, "login " + userLogin.getText().toString());
                Log.d(TAG, "login " + emailID.getText().toString());
            }
        });
        tvgoto_SignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, SignInActivity.class);
                startActivity(i);


            }
        });


    }


}
