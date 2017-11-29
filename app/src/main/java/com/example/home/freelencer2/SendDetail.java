package com.example.home.freelencer2;

/**
 * Created by Home on 11/27/2017.
 */

public class SendDetail {
    private static String name,addess,phone,problem,uid;

    public SendDetail(){

    }
    public SendDetail(String addess,String name,String phone,String problem){
        this.addess = addess;
        this.name = name;
        this.phone = phone;
        this.problem = problem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
