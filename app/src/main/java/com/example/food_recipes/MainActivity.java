package com.example.food_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etEnterCuisine;
    private Button btnHitApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();



    }

    private void initViews() {
        etEnterCuisine = findViewById(R.id.etEnterCuisine);
        btnHitApi = findViewById(R.id.btnHitApi);
        btnHitApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,QueryResponse_Activity.class);
                intent.putExtra("cuisineQuery",etEnterCuisine.getText().toString());
                startActivity(intent);
            }
        });
    }


}