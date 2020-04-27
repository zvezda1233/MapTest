package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class UserComment extends AppCompatActivity {
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_comment);

        Bundle extras = getIntent().getExtras();

//            int latitude = extras.getInt("latitude");
//            int longitude = extras.getInt("longitude");
            address = extras.getString("address");
            //The key argument here must match that used in the other activity

        TextView addresstw = findViewById (R.id.address_id);
        addresstw.setText(address);
}

}
