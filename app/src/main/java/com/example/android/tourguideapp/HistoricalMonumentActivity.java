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

public class HistoricalMonumentActivity extends AppCompatActivity {
    private ListView listView;
    private LocationAdapter Adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        /** create a list of hotels */
        final ArrayList<Locations> historicalMonumentsList = new ArrayList<>();
        historicalMonumentsList.add(new Locations(R.string.Imambara,R.drawable.imambara,R.string.Imambara_description));
        historicalMonumentsList.add(new Locations(R.string.Residency,R.drawable.residancy,R.string.Residency_description));
        historicalMonumentsList.add(new Locations(R.string.Satkhanda,R.drawable.satkhanda,R.string.Satkhanda_description));
        historicalMonumentsList.add(new Locations(R.string.Safed_Baradari,R.drawable.safed_baradari,R.string.Safed_Baradari_description));
        historicalMonumentsList.add(new Locations(R.string.Chattar_Manzil,R.drawable.chattar_manzil,R.string.Chattar_Manzil_description));
        historicalMonumentsList.add(new Locations(R.string.Rumi_Darwaza,R.drawable.rumi_darwaza,R.string.Rumi_Darwaza_description));

        /** Adding the list views */
        Adapter = new LocationAdapter(this, historicalMonumentsList, R.color.category_monuments);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        /**
         * adding the clickListener on the list items
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the Location object user has clicked on
                Locations location = historicalMonumentsList.get(position);

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
