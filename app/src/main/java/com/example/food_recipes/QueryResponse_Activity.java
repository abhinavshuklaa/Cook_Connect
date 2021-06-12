package com.example.food_recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueryResponse_Activity extends AppCompatActivity implements ApiViewHolder.onItemClickedListener {
    private  String getCuisineName;
    private List<MealsModel> list=new ArrayList<>();
    private ApiAdapter apiAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_response_);
        getDataFromIntent();
        initViews();
        setRecyclerAdapter();

    }

    private void setRecyclerAdapter() {
        apiAdapter=new ApiAdapter(list,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(apiAdapter);




    }


    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);



        ApiClient apiClient=Network.getRetrofitInstance(QueryResponse_Activity.this).create(ApiClient.class);
        Call<ResponseModel> call=apiClient.enterCuisine(getCuisineName);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.code()== HttpURLConnection.HTTP_OK && response.body()!= null){
                    if(response.body().getMeals()!=null){
                        ResponseModel responseModel=response.body();
                        list=responseModel.getMeals();
                        apiAdapter.updateAdapter(list);
                    }


                }else if(response.code()==HttpURLConnection.HTTP_NOT_FOUND){
                    Toast.makeText(QueryResponse_Activity.this, "Not Found ", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(QueryResponse_Activity.this, "Failed " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getDataFromIntent() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            getCuisineName=getIntent().getStringExtra("cuisineQuery");

        }

        }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "Item Clicked at position"+ position, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,YouTubePlay.class);
        intent.putExtra("link",list.get(position).getStrYoutube());
        startActivity(intent);
    }
}