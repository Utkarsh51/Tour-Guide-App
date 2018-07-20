package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    private ListView listView;
    private LocationAdapter Adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        /** create a list of hotels */
        final ArrayList<Locations> restaurantsList = new ArrayList<>();
        restaurantsList.add(new Locations(R.string.Tundey_Kebab,R.drawable.tunday,R.string.Tunday_description));
        restaurantsList.add(new Locations(R.string.Prakash_Kulfi,R.drawable.prakash_kulfi,R.string.Prakash_description));
        restaurantsList.add(new Locations(R.string.Royal_cafe,R.drawable.royal_cafe,R.string.Royal_cafe_description));
        restaurantsList.add(new Locations(R.string.Dastarkhwan,R.drawable.dastarkhwan,R.string.Dastarkhwan_description));
        restaurantsList.add(new Locations(R.string.sharma_tea,R.drawable.sharms_tea,R.string.sharma_tea_description));
        restaurantsList.add(new Locations(R.string.Moti_mahal,R.drawable.moti_mahal,R.string.Moti_mahal_description));
        restaurantsList.add(new Locations(R.string.piccadily, R.drawable.piccadily, R.string.piccadily_description));

        /** Adding the list views */
        Adapter = new LocationAdapter(this, restaurantsList, R.color.category_restaurants);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        /**
         * adding the clickListener on the list items
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the Location object user has clicked on
                Locations location = restaurantsList.get(position);

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
