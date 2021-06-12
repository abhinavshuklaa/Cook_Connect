package com.firstfood.food_recipes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.firstfood.food_recipes.R;

public class SplashScreen_Activity extends AppCompatActivity {
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_);
        handler = new Handler(getMainLooper());
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen_Activity.this, MainActivity.class);
                startActivity(intent);

            }
        }, 2000);

        Log.d("abhinav", "handler called for 4 seconds");
    }
}