package com.example.home.freelencer2;

/**
 * Created by Home on 11/8/2017.
 */

public class List_Technician {
    // public String image;
     public String name;
     public String phone;
     public String time;

    public List_Technician(){

    }
    public List_Technician( String name , String phone, String time){
        this.name = name;
        this.phone = phone;
        this.time = time;

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
}

