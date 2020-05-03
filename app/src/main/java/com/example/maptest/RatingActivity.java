package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
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
                Toast.makeText(RatingActivity.this, getString(R.string.action_rating), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_profile:
                Intent profile = new Intent(RatingActivity.this, ProfileActiivity.class);
                startActivity(profile);
                break;
            case R.id.action_map:
                Intent map = new Intent(RatingActivity.this, MapActivity.class);
                startActivity(map);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
