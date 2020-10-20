package com.example.food_recipes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

@GET("/api/json/v1/1/search.php/")
    Call<ResponseModel>enterCuisine(@Query("query") String enterCuisine);


}
//https://www.themealdb.com/api/json/v1/1/search.php?s=paneer