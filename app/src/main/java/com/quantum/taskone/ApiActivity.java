package com.quantum.taskone;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import adapters.ApiAdapter;
import apiPackage.ApiClient;
import apiPackage.ApiInterface;
import apiPackage.ApiModel;
import apiPackage. ApiModel;
import apiPackage.RequestData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {
    public static final String TAG="MainApiActivity";
    RecyclerView recyclerView;
    ApiAdapter apiAdapter=new ApiAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_activity);
        Log.d(TAG, "onCreate: ");

        recyclerView=findViewById(R.id.api_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(apiAdapter);

        ApiInterface apiInterface= ApiClient.getClient("livideoreversevideo",
                "IN", "Samsung", "NA", "1","23",
                "XHDPI","2","1","2","first_fitness").create(ApiInterface.class);

        Call< ApiModel> call=apiInterface.getExercise(new RequestData());

       call.enqueue(new Callback< ApiModel>() {
           @Override
           public void onResponse(Call< ApiModel> call, Response< ApiModel> response) {
               Log.d(TAG, "onResponse: "+response.body().getDayslist().get(4).getExercise());
               Log.d(TAG, "onResponse: "+response.raw().request().url());
               apiAdapter.setList(response.body().getDayslist().get(4).getExercise());
               apiAdapter.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call< ApiModel> call, Throwable t) {

           }
       });
    }
}
