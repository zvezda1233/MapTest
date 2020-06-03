package com.example.maptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class RatingActivity extends AppCompatActivity {
    private static final String TAG ="RatingActivity" ;

    DatabaseReference databaseUserComment;

    List<User_Info> infoList;
    ListView listView_usercomments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        databaseUserComment = FirebaseDatabase.getInstance().getReference("user_comment");

        listView_usercomments = (ListView) findViewById(R.id.listViewUser_info);

        infoList = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseUserComment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                infoList.clear();
                Log.d(TAG, "onDataChange():" + dataSnapshot.toString());
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User_Info info = userSnapshot.getValue(User_Info.class);

                    infoList.add(info);
                }
                UserCommentsList adapter = new UserCommentsList(RatingActivity.this, infoList);
                listView_usercomments.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
            case R.id.action_LOGOUT:
                FirebaseAuth.getInstance().signOut();
                Intent IntToSignUp = new Intent(RatingActivity.this, SignInActivity.class);
                Toast.makeText(this, "Return Application", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
