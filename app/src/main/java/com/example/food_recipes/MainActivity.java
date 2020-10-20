package com.example.food_recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etEnterCuisine;
    private RecyclerView recyclerView;
    private ImageView btnHitApi;
    private List<CuisineImages> cuisineImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecycleData();
        setRecyclerAdapter();



    }

    private void setRecyclerAdapter() {
        CuisineImageAdapter cuisineImageAdapter=new CuisineImageAdapter(cuisineImages);
        StaggeredGridLayoutManager gridLayoutManager=new StaggeredGridLayoutManager(4, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(cuisineImageAdapter);
    }

    private void buildRecycleData() {
        cuisineImages=new ArrayList<>();
        for(int i=0;i<100;i++){
            if(i%4==0){
                cuisineImages.add(new CuisineImages(R.drawable.food));
            }else if(i%4==1){
                cuisineImages.add(new CuisineImages(R.drawable.food_1));
            }else if(i%4==2){
                cuisineImages.add(new CuisineImages(R.drawable.food_3));
            }else{
                cuisineImages.add(new CuisineImages(R.drawable.food_4));
            }
        }

    }

    private void initViews() {
        etEnterCuisine = findViewById(R.id.etEnterCuisine);
        recyclerView=findViewById(R.id.rvImagesCuisine);
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