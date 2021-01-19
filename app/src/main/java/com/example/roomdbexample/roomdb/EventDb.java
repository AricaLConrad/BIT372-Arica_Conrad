package com.example.roomdbexample.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Event.class}, version = 1)
public abstract class EventDb extends RoomDatabase {
    // This is the name of the database.
    public final static String DATABASE_NAME = "EventsRoomDb";
    // This returns a data access object.
    public abstract EventDao eventDao();
}
