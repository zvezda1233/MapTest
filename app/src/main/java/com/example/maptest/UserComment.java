package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.TextUtils;
import android.util.Log;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class UserComment extends AppCompatActivity {
    private SlidrInterface slidr;
    private static final String TAG = "UserComment";

    //user data
    String address;
    String dateText;
    Spinner spinnerYES_NO;
    EditText comment;
    RatingBar ratingBar;
    Button saveButton;


    DatabaseReference databaseUserComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_comment);

        databaseUserComment = FirebaseDatabase.getInstance().getReference("user_comment");

        spinnerYES_NO = (Spinner) findViewById(R.id.spinnerYes_No);
        comment = (EditText) findViewById(R.id.comment_id);
        ratingBar = (RatingBar) findViewById(R.id.rating_rating_bar);
        saveButton = (Button) findViewById(R.id.save_button_id);


        final RatingBar ratingRatingBar = (RatingBar) findViewById(R.id.rating_rating_bar);


        Log.d(TAG, "addresses" + address);
        //address
        Bundle extras = getIntent().getExtras();
        address = extras.getString("address");
        TextView addressTW = findViewById(R.id.address_id);
        addressTW.setText(address);

        Log.d(TAG, "address" + address);

        //date
        TextView dateTW = findViewById(R.id.date_id);
        // Текущее время
        Date currentDate = new Date();
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        dateText = dateFormat.format(currentDate);
        dateTW.setText(dateText);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addUserComment();
            }
        });


        slidr = Slidr.attach(this);
    }

    private void addUserComment() {
        String adrs = address;
        String date = dateText;
        String spinner = spinnerYES_NO.getSelectedItem().toString();
        String comt = comment.getText().toString().trim();
        float stars = ratingBar.getRating();

        Log.d(TAG, "Data in Database" + address + dateText);
        if (!TextUtils.isEmpty(comt)) {
            Log.d(TAG, "AddData: Add Data in Database");
            String id = databaseUserComment.push().getKey();
            User_Info info = new User_Info(id, adrs, date, spinner, comt, stars);
            databaseUserComment.child(id).setValue(info);
            Toast.makeText(this, "Data added! Close page!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You should enter the comment", Toast.LENGTH_SHORT).show();
        }

    }

    public void lockSlide(View v) {
        slidr.lock();
    }

    public void unlockSlide(View v) {
        slidr.unlock();
    }

}








