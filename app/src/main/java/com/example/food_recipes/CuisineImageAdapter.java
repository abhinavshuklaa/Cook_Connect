package com.example.food_recipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CuisineImageAdapter extends RecyclerView.Adapter<CuisineImageViewHolder> {
    private List<CuisineImages> cuisineImagesList;

    public CuisineImageAdapter(List<CuisineImages> cuisineImagesList){
        this.cuisineImagesList=cuisineImagesList;
    }

    @NonNull
    @Override
    public CuisineImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisine_image_recycler_view,parent,false);
        return new CuisineImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuisineImageViewHolder holder, int position) {
CuisineImages cuisineImages=cuisineImagesList.get(position);
holder.setData(cuisineImages);
    }

    @Override
    public int getItemCount() {
        return cuisineImagesList.size();
    }
}
