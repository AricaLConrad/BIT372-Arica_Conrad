package com.example.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.roomdbexample.roomdb.Event;
import com.example.roomdbexample.roomdb.EventDao;
import com.example.roomdbexample.roomdb.EventDb;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This finds the event list section in the layout.
        eventList = findViewById(R.id.event_list);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Added this section.
        // This creates a new event database by passing in the parameters of the application
        // context, the database object class being built, and the name of the database.
        EventDb db = Room.databaseBuilder(getApplicationContext(),
                EventDb.class, EventDb.DATABASE_NAME).allowMainThreadQueries().build();
        // This creates a new data access object.
        EventDao dao = db.eventDao();
        // This creates a new adapter for the event's data and the event list layout.
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(), dao.getAllEvent());
        // Then set the adapter to the event list.
        eventList.setAdapter(adapter);
    }

    // Added this method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if they are present.
        getMenuInflater().inflate(R.menu.activity_main_menu_bar, menu);
        return true;
    }

    // Added this method.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Create a new intent for the CreateEventActivity.
        Intent intent = new Intent(this, CreateEventActivity.class);

        // This switch statement is useful if more buttons are added to the menu bar.
        switch (item.getItemId()) {
            // If the settings button is selected...
            case R.id.action_add:
                // Start the new activity (the CreateEventActivity).
                startActivity(intent);
            // A default, which was recommended in the tutorial link.
            // Tutorial link: https://www.tutlane.com/tutorial/android/android-options-menu-with-examples#divanomat
            // (This tutorial was shared by Teresa in the Slack channel.
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}