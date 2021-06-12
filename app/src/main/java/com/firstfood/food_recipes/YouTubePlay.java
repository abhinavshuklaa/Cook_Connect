package com.firstfood.food_recipes;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class YouTubePlay extends YouTubeBaseActivity {
    private static final String TAG = "MainActivity";
    private String url;
    private String v;


    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener onInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_play);
        Log.d(TAG, "onCreate");
        getDataFromIntent();

        btnPlay = (Button) findViewById(R.id.btnPlay);

        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.view2);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick : Initializing done");

                youTubePlayer.loadVideo(v);


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick : Initializing failed");

            }
        };


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick : Initializing Youtube Player");

                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), onInitializedListener);

            }
        });

    }


    private void getDataFromIntent() {
        Intent intent = getIntent();
        url = intent.getStringExtra("link");
        Uri uri = Uri.parse(url);
        v = uri.getQueryParameter("v");
    }
}