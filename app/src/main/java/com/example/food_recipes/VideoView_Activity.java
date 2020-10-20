package com.example.food_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoView_Activity extends AppCompatActivity {
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        getDataFromIntent();
        VideoView videoView=findViewById(R.id.videoView);
        videoView.setVideoPath(url);
        videoView.start();

    }

    private void getDataFromIntent() {
        Intent intent=getIntent();
        url=intent.getStringExtra("link");

    }
}