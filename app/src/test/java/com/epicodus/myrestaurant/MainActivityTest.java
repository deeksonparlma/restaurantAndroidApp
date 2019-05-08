package com.epicodus.myrestaurant;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }
    @Test
    public void  ValidateTextViewContent(){
        TextView appNameTextView =  activity.findViewById(R.id.appNameTextView);
        assertTrue("E-Restaurants".equals(appNameTextView.getText().toString()));
    }
}
