package com.example.food_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen_Activity extends AppCompatActivity {
    private VideoView videoView;
    private ImageView imageView;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_);
        videoView=findViewById(R.id.VideoViewSplashScreen);
        imageView=findViewById(R.id.imLogo);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SplashScreen_Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.recipe);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView.start();


        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },30000);
    }
}