package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    private ListView listView;
    private LocationAdapter Adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        /** create a list of hotels */
        final ArrayList<Locations> hotelsList = new ArrayList<>();
        hotelsList.add(new Locations(R.string.Clarks, R.drawable.clarks, R.string.clarks_description));
        hotelsList.add(new Locations(R.string.lebua_Lucknow, R.drawable.lebua, R.string.lebua_description));
        hotelsList.add(new Locations(R.string.Vivanta, R.drawable.vivanta, R.string.vivanta_desc));
        hotelsList.add(new Locations(R.string.Renaissance, R.drawable.ranaissance, R.string.Renaissance_desc));
        hotelsList.add(new Locations(R.string.novotel, R.drawable.novotel, R.string.novotel_description));
        hotelsList.add(new Locations(R.string.fairfield, R.drawable.fairfield, R.string.fairfield_description));
        hotelsList.add(new Locations(R.string.piccadily, R.drawable.piccadily, R.string.piccadily_description));

        /** Adding the list views */
        Adapter = new LocationAdapter(this, hotelsList, R.color.category_hotels);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        /**
         * adding the clickListener on the list items
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the Location object user has clicked on
                Locations location = hotelsList.get(position);

                setContentView(R.layout.location_detail);
                //find the detail image view
                ImageView image = (ImageView) findViewById(R.id.detail_image);
                image.setImageResource(location.getmImageResourceId());
                //find the name text view and set the name
                TextView name = (TextView) findViewById(R.id.detail_name);
                name.setText(location.getmName());
                //find the description text view and set the description
                TextView description = (TextView) findViewById(R.id.detail_description);
                description.setText(location.getmDescription());
            }
        });

    }
}

