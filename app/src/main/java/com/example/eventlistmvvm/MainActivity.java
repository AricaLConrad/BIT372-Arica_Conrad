package com.example.eventlistmvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventlistmvvm.roomdb.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

// This is the main activity of the app. By using ViewModels and repositories, this activity does
// not interact directly with the database.
public class MainActivity extends AppCompatActivity {

    // These establish the RecyclerView and ViewModel variables.
    private RecyclerView eventList;
    private EventListViewModel eventVM;

    // In onCreate, we need to create instances of the variables and access the views in the layout.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This creates a new intent that is connected to the CreateEventActivity class.
        // Then the floating action button is referenced.
        // When the floating action button is pressed, the CreateEventActivity will start.
        Intent intent = new Intent(this, CreateEventActivity.class);
        FloatingActionButton fab = findViewById(R.id.add_event_btn);
        fab.setOnClickListener((view) -> startActivity(intent));

        // This creates a reference to the event list in the activity_main.xml file.
        // A new LinearLayoutManager is set to the list, as RecyclerViews need a layout manager.
        eventList = findViewById(R.id.event_list);
        eventList.setLayoutManager(new LinearLayoutManager(this));

        // API 26 and up need a Factory with the ViewModel. The Factory essentially calls the
        // default constructor of the EventListViewModel class.
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        // To create a new ViewModel, a life cycle owner (which is this activity) and a factory
        // have to be passed, and then you get an instance of the ViewModel.
        eventVM = new ViewModelProvider(this, factory).get(EventListViewModel.class);
        eventVM.init(getApplicationContext());

        // This adapter is for the RecyclerView, and it needs a list of events, so the ViewModel's
        // getEvents method is called, which will return a MutableLiveData. The getValue method is
        // called to get whatever values are within the MutableLiveData.
        // Then the adapter is set to the event list in the layout so the layout will show the data.
        EventAdapter adapter = new EventAdapter(eventVM.getEvents().getValue());
        eventList.setAdapter(adapter);

        // A MutableLiveData needs to observe any changes to the data.
        // So, the ViewModel's getEvents method is called, returning the MutableLiveData, and
        // the observer is set to the MutableLiveData.
        eventVM.getEvents().observe(this, new Observer<List<Event>>() {
            // onChanged will only be called when the data has changed.
            // It will tell the adapter to update the data (calling the method updateData, which
            // essentially refreshes the data by deleting all the data and adding it all back in)
            // and then will notify the RecyclerView that the data has been updated.
            @Override
            public void onChanged(List<Event> events) {
                adapter.updateData(events);
                adapter.notifyDataSetChanged();
            }
        });
    }

    // Whenever this activity is resumed (such as when a new event is created and onBackPressed is
    // called), the ViewModel's getEvents method is called. We do not call the repository or the
    // database for showing the live data. getEvents will read the contents of the database,
    // but we are not directly accessing the database itself.
    // Calling getEvents will trigger the onChanged method above, as the data has changed.
    @Override
    protected void onResume() {
        super.onResume();
        eventVM.getEvents();
    }
}