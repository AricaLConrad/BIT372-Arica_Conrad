package com.example.eventlistmvvm.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Event {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate=true)
    public int _id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "img_id")
    public int img_id;

    public Event() {}

    public Event(String title, String date, int imgId) {
        this.title = title;
        this.date = date;
        this.img_id = imgId;
    }
}
