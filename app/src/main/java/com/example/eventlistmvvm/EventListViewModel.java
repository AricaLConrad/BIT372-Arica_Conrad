package com.example.eventlistmvvm;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eventlistmvvm.roomdb.Event;

import java.util.List;

// The ViewModel contains the live data.
public class EventListViewModel extends ViewModel {
    // The MutableLiveData list is also following the singleton pattern.
    private MutableLiveData<List<Event>> eventsData;
    private EventRepository repo;

    // Just like the EventRepository singleton, if there is no instance of the MutableLiveData list,
    // a new one is created (instantiated).
    // "init" is short for initialize, and it is sort of a different way of creating a constructor.
    // This is to initialize all the variables and pass in the context so the ViewModel Factory in
    // the MainActivity can use it.
    public void init(Context context) {
        if (eventsData == null) {
            eventsData = new MutableLiveData<>();
        }
        // Only one instance of the repository is ever created (instantiated), and the eventsData list
        // is set to the events that are returned when calling the repository's getEvents method.
        repo = EventRepository.getInstance(context);
        eventsData.setValue(repo.getEvents());
    }

    // This calls the getEvents method in the EventRepository class and sets the MutableLiveData
    // list to whatever was returned. Then the list is returned.
    // We call the repository to get the data in case the data has changed in the database.
    // getEvents will read the contents of the database, but we are not directly accessing the database itself.
    public MutableLiveData<List<Event>> getEvents() {
        eventsData.setValue(repo.getEvents());
        return eventsData;
    }
}
