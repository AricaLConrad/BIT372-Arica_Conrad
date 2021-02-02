package com.example.eventlistmvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventlistmvvm.roomdb.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private List<Event> events;

    public EventAdapter(List<Event> events){
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,
                        parent,
                        false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = this.events.get(position);
        holder.getEventImage().setImageResource(event.img_id);
        holder.getDateText().setText(event.date);
        holder.getTitleText().setText(event.title);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    // This essentially acts like a refresh, where all the data in the list is cleared and then
    // all the data is added back in.
    public void updateData(List<Event> events) {
        this.events.clear();
        this.events.addAll(events);
    }
}


class EventViewHolder extends RecyclerView.ViewHolder {

    private TextView titleText;
    private TextView dateText;
    private ImageView eventImage;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.event_title_text);
        dateText = itemView.findViewById(R.id.event_date_text);
        eventImage = itemView.findViewById(R.id.event_img_holder);
    }

    public TextView getTitleText() {
        return titleText;
    }

    public TextView getDateText() {
        return dateText;
    }

    public ImageView getEventImage() {
        return eventImage;
    }
}