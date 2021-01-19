package com.example.roomdbexample.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// DAO means Data Access Object.

@Dao
public interface EventDao {
    @Query("SELECT * FROM event")
    List<Event> getAllEvent();

    // Since we are only inserting events, I decided to remove the deleteEvent and updateEvent code.
    @Insert
    void insertEvent(Event event);
}
