package com.example.retrofitdatafetchurldemo;

import androidx.annotation.NonNull;

public class DataClass{

    private int id;
    private int userid;
    private String title;
    private boolean completed;

    public DataClass(int id, int userid, String title, boolean completed) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.completed = completed;
    }

    public DataClass(int userid, String title, boolean completed) {
        this.userid = userid;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "DataClass{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}



