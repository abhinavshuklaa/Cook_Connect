package com.firstfood.food_recipes;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CuisineImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;


    public CuisineImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imCuisine);

    }

    public void setData(CuisineImages cuisineImages) {
        imageView.setImageResource(cuisineImages.getPicID());
    }
}
