package com.example.eventlistmvvm.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Event.class}, version = 1)
public abstract class EventDb extends RoomDatabase {
    public final static String DATABASE_NAME = "EventsRoomDb";
    public abstract EventDao eventDao();
}
