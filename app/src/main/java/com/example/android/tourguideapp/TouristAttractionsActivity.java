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

public class TouristAttractionsActivity extends AppCompatActivity {
    private ListView listView;
    private LocationAdapter Adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        /** create a list of hotels */
        final ArrayList<Locations> touristAttractionList = new ArrayList<>();
        touristAttractionList.add(new Locations(R.string.hazratganz,R.drawable.hazratganj,R.string.hazratganj_description));
        touristAttractionList.add(new Locations(R.string.Lucknow_Zoo,R.drawable.lucknow_zoo,R.string.zoo_description));
        touristAttractionList.add(new Locations(R.string.ambedkar_park,R.drawable.ambedkar_park,R.string.ambedkar_park_description));
        touristAttractionList.add(new Locations(R.string.math,R.drawable.ramakrishna,R.string.math_description));
        touristAttractionList.add(new Locations(R.string.Marine_Drive,R.drawable.marine_drive,R.string.marine_drive_description));
        touristAttractionList.add(new Locations(R.string.jmpark,R.drawable.janeswar,R.string.jmpark_description));

        /** Adding the list views */
        Adapter = new LocationAdapter(this, touristAttractionList, R.color.category_attractions);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        /**
         * adding the clickListener on the list items
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the Location object user has clicked on
                Locations location = touristAttractionList.get(position);
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
