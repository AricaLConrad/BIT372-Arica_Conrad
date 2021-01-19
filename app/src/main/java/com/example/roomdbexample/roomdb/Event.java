package com.example.roomdbexample.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// This represents what one event object contains. This is a table.

@Entity
public class Event {

    // This creates the id column, which is the primary key and is auto-generated.
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public int _id;

    // This creates the title column, which represents the name of the event.
    @ColumnInfo(name = "title")
    public String title;

    // This creates the date column, which represents the date of the event.
    @ColumnInfo(name = "date")
    public String date;

    // This creates the image id column, which represents the id of the image that will be
    // displayed for each event.
    @ColumnInfo(name = "img_id")
    public int img_id;

    // This is a constructor.
    public Event() {}

    // This is another constructor.
    public Event(String title, String date, int img_id) {
        this.title = title;
        this.date = date;
        this.img_id = img_id;
    }
}
