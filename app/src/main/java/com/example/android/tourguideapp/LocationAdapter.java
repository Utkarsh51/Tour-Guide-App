package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Locations> {
    private int mColorResourceId;

    public LocationAdapter(Activity context, ArrayList<Locations> locations, int colorResourceId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        //check if the existing viewis used or inflate the new view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        //get the object located at this position in the list
        Locations currentLocation = getItem(position);
        //find the text view with id name
        TextView name = (TextView) listItemView.findViewById(R.id.name);
        //set the name of the location on this text view
        name.setText(currentLocation.getmName());

        // find the image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentLocation.getmImageResourceId());
        imageView.setVisibility(View.VISIBLE);
        //set the theme color for list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

