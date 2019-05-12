package com.epicodus.myrestaurant;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  @BindView(R.id.findbutton) Button mFindRestaurantsButton;
  @BindView(R.id.appNameTextView) TextView mAppNameTextView;
  @BindView(R.id.locationInput) EditText mlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");

//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String location = mlocation.getText().toString();
//                Toast.makeText(MainActivity.this , "searching .." ,Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(MainActivity.this , RestaurantActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//            }
//        });
        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String location = mlocation.getText().toString();
            Toast.makeText(MainActivity.this, "searching ..", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
