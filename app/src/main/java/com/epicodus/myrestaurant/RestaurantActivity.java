package com.epicodus.myrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {
    private TextView mLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        mLocation = (TextView) findViewById(R.id.locationDisplay);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocation.setText("Here are all the restaurants near: " + location);
    }
}
