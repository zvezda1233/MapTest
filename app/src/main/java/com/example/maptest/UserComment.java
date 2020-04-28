package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class UserComment extends AppCompatActivity {
    String address;
    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_comment);

        final RatingBar ratingRatingBar = (RatingBar) findViewById(R.id.rating_rating_bar);


        //close


        //address
        Bundle extras = getIntent().getExtras();
        address = extras.getString("address");
        TextView addressTW = findViewById(R.id.address_id);
        addressTW.setText(address);

        //date
        TextView dateTW = findViewById(R.id.date_id);
        // Текущее время
        Date currentDate = new Date();
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        dateTW.setText(dateText);

        slidr = Slidr.attach(this);
    }

    public void lockSlide(View v) {
        slidr.lock();
    }

    public void unlockSlide(View v) {
        slidr.unlock();
    }

}








