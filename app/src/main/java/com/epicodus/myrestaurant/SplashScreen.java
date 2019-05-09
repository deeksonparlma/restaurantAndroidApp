package com.epicodus.myrestaurant;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends Activity {
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run(){
                        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1200);

//        MediaPlayer mediaPlayer= MediaPlayer.create(SplashScreen.this,R.raw.song);
//        mediaPlayer.start();
    }
}
