package com.example.eventlistmvvm;

import android.content.Context;

import androidx.room.Room;

import com.example.eventlistmvvm.roomdb.Event;
import com.example.eventlistmvvm.roomdb.EventDb;

import java.util.List;

// This creates a new event repository. A repository is an extra layer between whatever we are
// using and our database.
public class EventRepository {
    // This is following the "singleton pattern," where only one instance of this class can be
    // created (instantiated). This is because we only want one event repository.
    private EventDb db;
    private static EventRepository instance;

    // Nothing outside of this class can call the constructor, because it is private.
    private EventRepository() {}

    // This returns an instance of the class. If it is null, then a new instance of the class is
    // created and a new database is instantiated based on the instance.
    public static EventRepository getInstance(Context context) {
        if (instance == null) {
            instance = new EventRepository();
            instance.db = Room.databaseBuilder(context, EventDb.class,
                    EventDb.DATABASE_NAME).allowMainThreadQueries().build();
        }

        return instance;
    }

    // This calls the EventDao interface's getAllEvents method and returns a list of all of the
    // events in the database.
    public List<Event> getEvents() {
        return db.eventDao().getAllEvent();
    }

    // This calls the EventDao interface's insertEvent method and inserts the event into the database.
    public void insertEvent(Event event) {
        db.eventDao().insertEvent(event);
    }
}
