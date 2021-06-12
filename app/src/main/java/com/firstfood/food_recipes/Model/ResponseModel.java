package com.firstfood.food_recipes.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    @SerializedName("meals")
    private List<MealsModel> meals;

    public ResponseModel(List<MealsModel> meals) {
        this.meals = meals;
    }

    public List<MealsModel> getMeals() {
        return meals;
    }
}