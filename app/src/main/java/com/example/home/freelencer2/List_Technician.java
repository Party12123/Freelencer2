package com.example.home.freelencer2;

import android.content.Context;

/**
 * Created by Home on 11/8/2017.
 */

public class List_Technician {
    // public String image;
     private String name;
     private String phone;
     private String time;
     private String image;
     private String uid;
     private Context getcontext;

    public List_Technician(){

    }
    public List_Technician( String name , String phone, String time,String image,String uid){
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.image = image;
        this.uid = uid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getTime() {
        return time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Context getGetcontext() {
        return getcontext;
    }

    public void setGetcontext(Context getcontext) {
        this.getcontext = getcontext;
    }
}

