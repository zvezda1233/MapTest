package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.text.Text;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class ProfileActiivity extends AppCompatActivity {

    private static final String TAG = "Profile";
    String username;
    String e_mail;


    FirebaseAuth mFirebaseAuth;
    DatabaseReference getUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actiivity);

        mFirebaseAuth = FirebaseAuth.getInstance();
        getUser = FirebaseDatabase.getInstance().getReference("2i6bqIalm4PcUIsWsQcmxE0bRMQ2\n");
        Log.d(TAG, "Error first " + getUser);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            String email = user.getEmail();
            TextView useremailTW = findViewById(R.id.user_email_profile);
            useremailTW.setText(email);

//            String name = user.getDisplayName();
//            TextView usernameTW = findViewById(R.id.username_profile);
//            usernameTW.setText(name);
        } else {
            // No user is signed in
        }

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            username = extras.getString("username");
//            TextView usernameTW = findViewById(R.id.username_profile);
//            Log.d(TAG, "Error first " + username + " " + e_mail);
//            usernameTW.setText(username);
//        }
//
//
//        Bundle extras1 = getIntent().getExtras();
//        if (extras1 != null) {
//            e_mail = extras1.getString("email_for_profile");
//            TextView useremailTW = findViewById(R.id.user_email_profile);
//            useremailTW.setText(e_mail);
//
//        }

        Log.d(TAG, "Error second " + username + " " + e_mail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_rating:
                Intent rating = new Intent(ProfileActiivity.this, RatingActivity.class);
                startActivity(rating);
                break;
            case R.id.action_profile:
                Toast.makeText(ProfileActiivity.this, getString(R.string.action_profile), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_map:
                Intent profile = new Intent(ProfileActiivity.this, MapActivity.class);
                startActivity(profile);
                break;
            case R.id.action_LOGOUT:

                FirebaseAuth.getInstance().signOut();
                Intent IntToSignUp = new Intent(ProfileActiivity.this, SignInActivity.class);
                Toast.makeText(this, "Return Application", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
