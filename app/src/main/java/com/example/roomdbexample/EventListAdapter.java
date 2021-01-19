package com.example.roomdbexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.roomdbexample.roomdb.Event;

import java.util.List;

public class EventListAdapter extends ArrayAdapter<Event> {
    public EventListAdapter(@NonNull Context context, @NonNull List<Event> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, parent, false);
        }

        TextView eventTitle = convertView.findViewById(R.id.event_title_text);
        TextView eventDate = convertView.findViewById(R.id.event_date_text);
        ImageView eventImg = convertView.findViewById(R.id.event_img_holder);

        Event event = getItem(position);
        eventTitle.setText(event.title);
        eventDate.setText(event.date);
        eventImg.setImageResource(event.img_id);

        return convertView;
    }
}
