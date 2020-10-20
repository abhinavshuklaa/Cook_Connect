package com.example.food_recipes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ApiViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
    private TextView tvTitleCuisineName;
    private TextView tvInstructions;
    private TextView tvArea;
    private TextView tvCategory;
    private ImageView imThumb;
    private onItemClickedListener onItemClickedListener;


    public ApiViewHolder(@NonNull View itemView, onItemClickedListener onItemsClickedListener) {
        super(itemView);
        this.onItemClickedListener=onItemsClickedListener;
        initViews();
    }

    private void initViews() {
        tvTitleCuisineName=itemView.findViewById(R.id.tvTitleCuisineName);
        tvInstructions=itemView.findViewById(R.id.tvInstructions);
        tvArea=itemView.findViewById(R.id.tvArea);
        tvCategory=itemView.findViewById(R.id.tvCategory);
        imThumb=itemView.findViewById(R.id.imCuisineImage);


    }

    public void setData(MealsModel mealsModel) {
        Picasso.get().load(mealsModel.getStrMealThumb()).into(imThumb);
        tvArea.setText("Origin :"+mealsModel.getStrArea());
        tvCategory.setText("Meal Type :"+mealsModel.getStrCategory());
        tvInstructions.setText(mealsModel.getStrInstructions());
        tvTitleCuisineName.setText(mealsModel.getStrMeal());


    }

    @Override
    public void onClick(View view) {
        onItemClickedListener.onItemClicked(getAdapterPosition());

    }

    public interface onItemClickedListener{
        void onItemClicked(int position);
    }

}
