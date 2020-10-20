package com.example.food_recipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiViewHolder> {
    private List<MealsModel> list;


    public ApiAdapter (List<MealsModel> mealsModelList){

        list=mealsModelList;
    }
    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_layout,parent,false);

        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
    MealsModel mealsModel=list.get(position);
    holder.setData(mealsModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void updateAdapter(List<MealsModel> mealsModelList){
        this.list=mealsModelList;
        notifyDataSetChanged();
    }
}
