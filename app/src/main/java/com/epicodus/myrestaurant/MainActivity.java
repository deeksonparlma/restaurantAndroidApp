package com.epicodus.myrestaurant;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mFindRestaurantsButton;
    private EditText mlocation;
    private TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        mAppNameTextView.setTypeface(ostrichFont);
        mlocation = (EditText) findViewById(R.id.locationInput);
        mFindRestaurantsButton = (Button) findViewById(R.id.findbutton);

        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String location = mlocation.getText().toString();
                Toast.makeText(MainActivity.this , "searching .." ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this , RestaurantActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }

}
