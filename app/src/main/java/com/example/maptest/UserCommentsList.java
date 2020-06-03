package com.example.maptest;

import android.app.Activity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;

import codingwithmitch.com.googlemapsgoogleplaces.R;

public class UserCommentsList extends ArrayAdapter<User_Info> {
    private Activity context;
    private List<User_Info> user_info_list;

    public UserCommentsList(Activity context, List<User_Info> user_info_list) {
        super(context, R.layout.list_layout, user_info_list);
        this.context = context;
        this.user_info_list = user_info_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textView_place = (TextView) listViewItem.findViewById(R.id.textViewplace);
        TextView textView_data = (TextView) listViewItem.findViewById(R.id.textViewdate);
        TextView textView_spinner = (TextView) listViewItem.findViewById(R.id.textViewspinner);
        TextView textView_comment = (TextView) listViewItem.findViewById(R.id.textViewcomment);
        TextView textView_stars = (TextView) listViewItem.findViewById(R.id.textViewstars);

        User_Info information = user_info_list.get(position);

        textView_place.setText(information.getUser_place().toString());
        textView_data.setText(String.valueOf(information.getUser_date()));
        textView_spinner.setText(information.getUser_spinner());
        textView_comment.setText(information.getUser_comment());
        textView_stars.setText(NumberFormat.getInstance().format(information.getUser_stars()) );
        //stars

        return listViewItem;
    }
}
