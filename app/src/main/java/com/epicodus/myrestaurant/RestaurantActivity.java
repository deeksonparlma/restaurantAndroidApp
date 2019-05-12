package com.epicodus.myrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    public static final String TAG = RestaurantActivity.class.getSimpleName();

    private String[] restaurants = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};
    private String[] cuisines = new String[]{"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican"};

    @BindView(R.id.locationDisplay)
    TextView mLocation;
    @BindView(R.id.listView)
    ListView mListView;
    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        ButterKnife.bind(this);
        MyRestaurantAdapter adapter = new MyRestaurantAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String restaurant = ((TextView) view).getText().toString();
                Toast.makeText(RestaurantActivity.this, restaurant, Toast.LENGTH_SHORT).show();
            }
        });
        //intent//
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocation.setText("Here are all the restaurants near: " + location);
        getRestaurants(location);

    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mRestaurants = yelpService.processResults(response);

                RestaurantActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String[] restaurantNames = new String[mRestaurants.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = mRestaurants.get(i).getName();
                    }

                        ArrayAdapter adapter = new ArrayAdapter(RestaurantActivity.this,
                                android.R.layout.simple_list_item_1, restaurantNames);
                        mListView.setAdapter(adapter);
                });
            }
        });
    }
}

