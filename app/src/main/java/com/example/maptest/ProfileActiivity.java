package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class ProfileActiivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actiivity);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        switch (id){
            case R.id.action_rating:
                Intent rating = new Intent(ProfileActiivity.this, RatingActivity.class);
                startActivity(rating);
                break;
            case R.id.action_profile:
                Toast.makeText(ProfileActiivity.this,getString(R.string.action_profile),Toast.LENGTH_LONG).show();
                break;
            case R.id.action_map:
                Intent profile = new Intent(ProfileActiivity.this,MapActivity .class);
                startActivity(profile);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
