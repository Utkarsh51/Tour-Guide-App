package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view that shows the hotels category
        TextView hotels = (TextView) findViewById(R.id.hotels);
        //set onclick listener on the view
        hotels.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent hotelsIntent = new Intent(MainActivity.this, HotelsActivity.class);
                startActivity(hotelsIntent);
            }
        });

        //find the view that shows the historical monuments category
        TextView historicalMonuments = (TextView) findViewById(R.id.historical_monuments);
        //set onclick listener on the view
        historicalMonuments.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent historicalMonumentsIntent = new Intent(MainActivity.this, HistoricalMonumentActivity.class);
                startActivity(historicalMonumentsIntent);
            }
        });

        //find the view that shows the restaurants category
        TextView restaurants = findViewById(R.id.restaurants);
        //set onclick listener
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantIntent = new Intent(MainActivity.this,RestaurantsActivity.class);
                startActivity(restaurantIntent);
            }
        });

        //find the view that shows the attractions category
        TextView attractions = findViewById(R.id.attractions);
        //set onclick listener
        attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attractionIntent = new Intent(MainActivity.this,TouristAttractionsActivity.class);
                startActivity(attractionIntent);
            }
        });
    }
}
