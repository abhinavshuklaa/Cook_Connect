package com.example.food_recipes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("/api/json/v1/1/search.php/")
    Call<ResponseModel> enterCuisine(@Query("s") String enterCuisine);


}
//https://www.themealdb.com/api/json/v1/1/search.php?s=paneer

//https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=d3aecd6c9568466b8595bdebbed9feac