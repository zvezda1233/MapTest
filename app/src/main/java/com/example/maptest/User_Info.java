package com.example.maptest;

public class User_Info {
    String user_comment_id = "";
    String user_place = "";
    String user_date = "";
    String user_spinner = "";
    String user_comment = "";
    Float user_stars;

    public User_Info() {
    }


    public User_Info(String user_comment_id, String user_place, String user_date, String user_spinner, String user_comment, Float user_stars) {
        this.user_comment_id = user_comment_id;
        this.user_place = user_place;
        this.user_date = user_date;
        this.user_spinner = user_spinner;
        this.user_comment = user_comment;
        this.user_stars = user_stars;
    }

    public String getUser_comment_id() {
        return user_comment_id;
    }

    public String getUser_place() {
        return user_place;
    }

    public String getUser_date() {
        return user_date;
    }

    public String getUser_spinner() {
        return user_spinner;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public Float getUser_stars() {
        return user_stars;
    }
}
