package com.firstfood.food_recipes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firstfood.food_recipes.ApiViewHolder;
import com.firstfood.food_recipes.Model.MealsModel;
import com.firstfood.food_recipes.R;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiViewHolder> {
    private List<MealsModel> list;
    private ApiViewHolder.onItemClickedListener onItemClickedListener;


    public ApiAdapter(List<MealsModel> mealsModelList, ApiViewHolder.onItemClickedListener onItemClickedListener) {

        list = mealsModelList;
        this.onItemClickedListener = onItemClickedListener;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_layout, parent, false);

        return new ApiViewHolder(view, onItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        MealsModel mealsModel = list.get(position);
        holder.setData(mealsModel);
    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public void updateAdapter(List<MealsModel> mealsModelList) {
        this.list = mealsModelList;
        notifyDataSetChanged();
    }
}


